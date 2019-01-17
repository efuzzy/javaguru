package lv.javaguru.vika.papp.jms.responsehandlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.jms.JMSResponse;
import lv.javaguru.vika.commons.jms.JMSSubscribeUserResponse;
import lv.javaguru.vika.commons.jms.SupportedCommandId;
import lv.javaguru.vika.papp.jms.JMSResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
class JMSSubscribeResponseHandler implements JMSResponseHandler {

    @Autowired private ObjectMapper objectMapper;

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.SUBSCRIBE;
    }

    @Override
    public ResponseEntity process(JMSResponse jmsResponse) {
        String payload = jmsResponse.getPayload();
        JMSSubscribeUserResponse response;
        try {
            response = objectMapper.readValue(payload, JMSSubscribeUserResponse.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(response.getUser());
    }

}
