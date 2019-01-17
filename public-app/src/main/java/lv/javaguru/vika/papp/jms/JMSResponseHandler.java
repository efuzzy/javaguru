package lv.javaguru.vika.papp.jms;

import lv.javaguru.vika.commons.jms.JMSResponse;
import org.springframework.http.ResponseEntity;

public interface JMSResponseHandler {

    String getSupportedCommandId();

    default boolean canProcess(JMSResponse response) {
        return response.getCommandId().equals(getSupportedCommandId());
    }

    ResponseEntity process(JMSResponse jmsResponse);

}
