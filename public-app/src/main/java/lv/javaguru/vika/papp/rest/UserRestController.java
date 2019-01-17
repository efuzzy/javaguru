package lv.javaguru.vika.papp.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.commons.jms.JMSRequest;
import lv.javaguru.vika.commons.jms.JMSSubscribeUserRequest;
import lv.javaguru.vika.papp.jms.JMSRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.UUID;

@RestController
@RequestMapping(
        value = "/api",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class UserRestController {
   @Autowired private JMSRequestSender jmsRequestSender;
   @Autowired private ObjectMapper objectMapper;
   @Autowired private DeferredResultHolder deferredResultHolder;


    @PostMapping(value="/subscribe")
    public DeferredResult<ResponseEntity> subscribe(@RequestParam("userId")Long userId) {
        JMSSubscribeUserRequest jmsSubscrRequest = new JMSSubscribeUserRequest();
        jmsSubscrRequest.setUserId(userId);
        String payload;
        try {
            payload = objectMapper.writeValueAsString(jmsSubscrRequest);
        } catch (
        JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JMSRequest jmsRequest = JMSRequest.builder().commandId(jmsSubscrRequest.getCommandId())
                .correlationId(UUID.randomUUID().toString()).payload( payload).build();

        DeferredResult<ResponseEntity> deferredResult = buildDeffRes();
        jmsRequestSender.send(jmsRequest);
        deferredResultHolder.put(jmsRequest, deferredResult);


        return deferredResult;
    }
    private DeferredResult<ResponseEntity> buildDeffRes() {
        DeferredResult<ResponseEntity> response = new DeferredResult<>(5000L);
        response.onTimeout(() ->
                response.setErrorResult(
                        ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout occurred.:)")
                )
        );
        return response;
    }

}
