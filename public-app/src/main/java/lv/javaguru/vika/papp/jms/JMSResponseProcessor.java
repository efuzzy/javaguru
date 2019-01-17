package lv.javaguru.vika.papp.jms;

import lv.javaguru.vika.commons.errors.InternalServerError;
import lv.javaguru.vika.commons.jms.JMSResponse;
import lv.javaguru.vika.papp.rest.DeferredResultHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public interface JMSResponseProcessor {
    void process(JMSResponse response);
}

@Component
class JMSResponseProcessorImpl implements JMSResponseProcessor {

    @Autowired
    private List<JMSResponseHandler> responseHandlers;
    @Autowired
    private DeferredResultHolder deferredResultHolder;
    @Autowired
    private HttpStatusMapper httpStatusMapper;

    @Override
    public void process(JMSResponse jmsResponse) {
        if (jmsResponse.isSuccess()) {
            processSuccessfulResponse(jmsResponse);
        } else {
            processFailedResponse(jmsResponse);
        }
    }

    private void processSuccessfulResponse(JMSResponse jmsResponse) {
        ResponseEntity responseEntity = responseHandlers.stream()
                .filter(ch -> ch.canProcess(jmsResponse))
                .findFirst()
                .orElseThrow(InternalServerError::new)
                .process(jmsResponse);
        process(jmsResponse, responseEntity);
    }

    private void processFailedResponse(JMSResponse jmsResponse) {
        process(jmsResponse,
                ResponseEntity
                        .status(httpStatusMapper.map(jmsResponse.getResponseStatus()))
                        .body(jmsResponse.getPayload())
        );
    }

    private void process(JMSResponse jmsResponse,
                         ResponseEntity responseEntity) {
        deferredResultHolder.get(jmsResponse.getCorrelationId())
                .orElseThrow(InternalServerError::new)
                .setResult(responseEntity);
    }

}
