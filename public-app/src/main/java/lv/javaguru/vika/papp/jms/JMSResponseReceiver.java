package lv.javaguru.vika.papp.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.jms.JMSQueues;
import lv.javaguru.vika.commons.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
class JMSResponseReceiver {

    @Autowired private ObjectMapper objectMapper;
    @Autowired private JMSResponseProcessor jmsResponseProcessor;

    @JmsListener(destination = JMSQueues.PUBLIC_APP_RESPONSE_QUEUE,
                 selector = "JMSCorrelationID = '#{ApplicationCorrelationIdHolder.CORRELATION_ID}'",
                 concurrency = "${jms.response.listener.concurrency:10}")
    public void onMessage(TextMessage message) throws JMSException {
        String messageText = message.getText();
        JMSResponse response;
        try {
            response = objectMapper.readValue(messageText, JMSResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        jmsResponseProcessor.process(response);
    }

}
