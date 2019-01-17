package lv.javaguru.vika.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import lv.javaguru.vika.api.CommandExecutor;
import lv.javaguru.vika.api.commands.DomainCommand;
import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.jms.JMSRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public abstract class JMSRequestHandler {

    @Autowired protected CommandExecutor commandExecutor;
    @Autowired private ObjectMapper objectMapper;

    public abstract String getSupportedCommandId();

    protected boolean canProcess(JMSRequest request) {
        return request.getCommandId().equals(getSupportedCommandId());
    }

    public abstract String process(JMSRequest request);

    public <T> T mapRequest(JMSRequest request, Class<T> clazz) {
        String payload = request.getPayload();
        try {
            return objectMapper.readValue(payload, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected <C extends DomainCommand<T>, T extends DomainCommandResult> T executeCoreCommand(DomainCommand<T> coreCommand) {
        return commandExecutor.execute(coreCommand);
    }

    protected String buildPayload(Object jmsResponse) {
        try {
            return objectMapper.writeValueAsString(jmsResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
