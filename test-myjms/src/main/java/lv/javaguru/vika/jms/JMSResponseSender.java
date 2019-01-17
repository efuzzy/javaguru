package lv.javaguru.vika.jms;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.jms.JMSQueues;
import lv.javaguru.vika.commons.jms.JMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

public interface JMSResponseSender {
    void send(JMSResponse response, String correlationId);
}

@Component
class JMSResponseSenderImpl implements JMSResponseSender {

    @Autowired private JmsTemplate jmsTemplate;
    @Autowired private ObjectMapper objectMapper;
    private static final Long JMS_REQUEST_TIMEOUT = 5000L;

    @Override
    public void send(JMSResponse response, String correlationId) {
        jmsTemplate.send(JMSQueues.PUBLIC_APP_RESPONSE_QUEUE, session ->
                build(session, response, correlationId)
        );
    }

    public TextMessage build(Session session,
                             JMSResponse response,
                             String jmsCorrelationId) throws JMSException {
        String responseMessage = null;
        try {
            responseMessage = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        TextMessage outMessage = session.createTextMessage(responseMessage);
        outMessage.setJMSCorrelationID(jmsCorrelationId);
        outMessage.setJMSExpiration(JMS_REQUEST_TIMEOUT);
        return outMessage;
    }
}
