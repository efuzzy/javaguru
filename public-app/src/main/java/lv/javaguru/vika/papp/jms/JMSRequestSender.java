package lv.javaguru.vika.papp.jms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.jms.JMSQueues;
import lv.javaguru.vika.commons.jms.JMSRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;


public interface JMSRequestSender {

    void send(JMSRequest jmsRequest);

}

@Component
class JMSRequestSenderImpl implements JMSRequestSender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void send(JMSRequest jmsRequest) {

        jmsTemplate.send(JMSQueues.PUBLIC_APP_REQUEST_QUEUE, session -> {
            String message = mapToString(jmsRequest);
            TextMessage textMessage = session.createTextMessage(message);
            textMessage.setJMSCorrelationID(ApplicationCorrelationIdHolder.CORRELATION_ID);

            return textMessage;
        });
    }

    public String mapToString(JMSRequest jmsRequest) {
        try {
            return objectMapper.writeValueAsString(jmsRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
