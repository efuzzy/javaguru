package lv.javaguru.vika.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.enums.ResponseStatus;
import lv.javaguru.vika.commons.jms.JMSQueues;
import lv.javaguru.vika.commons.jms.JMSRequest;
import lv.javaguru.vika.commons.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;
import java.util.List;

@Component
class JMSRequestReceiver {

    @Autowired private JMSResponseSender jmsResponseSender;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private List<JMSRequestHandler> requestHandlers;

    @JmsListener(destination = JMSQueues.PUBLIC_APP_REQUEST_QUEUE,
            concurrency = "${jms.client.request.listener.concurrency:10}")
    public void onMessage(TextMessage inMessage) throws JMSException {
        System.out.println("<<<<<<<<<<<<<<<<<<<< got message!!!:) " + inMessage);
        processRequest(inMessage);
    }

    protected void processRequest(TextMessage inMessage) throws JMSException {
        String messageText = inMessage.getText();
        JMSRequest request;
        try {
            request = objectMapper.readValue(messageText, JMSRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String payload = selectHandlerAndProcessRequest(request);
        JMSResponse response = build(request, ResponseStatus.SUCCESS, payload);
        jmsResponseSender.send(response, inMessage.getJMSCorrelationID());
    }

    private String selectHandlerAndProcessRequest(JMSRequest request) {
        return requestHandlers.stream()
                .filter(ch -> ch.canProcess(request))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .process(request);
    }

    private JMSResponse build(JMSRequest request, ResponseStatus responseStatus, String payload) {
        JMSResponse response = new JMSResponse();
        response.setCommandId(request.getCommandId());
        response.setCorrelationId(request.getCorrelationId());
        response.setResponseStatus(responseStatus);
        response.setPayload(payload);
        return response;
    }

}
