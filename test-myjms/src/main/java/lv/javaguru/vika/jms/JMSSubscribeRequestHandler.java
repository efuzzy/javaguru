package lv.javaguru.vika.jms;

import lv.javaguru.vika.api.commands.users.SubscribeUserCommand;
import lv.javaguru.vika.api.commands.users.SubscribeUserResult;
import lv.javaguru.vika.commons.jms.JMSRequest;
import lv.javaguru.vika.commons.jms.JMSSubscribeUserRequest;
import lv.javaguru.vika.commons.jms.JMSSubscribeUserResponse;
import lv.javaguru.vika.commons.jms.SupportedCommandId;
import org.springframework.stereotype.Component;

@Component
class JMSSubscribeRequestHandler extends JMSRequestHandler {

    @Override
    public String getSupportedCommandId() {
        return SupportedCommandId.SUBSCRIBE;
    }

    @Override
    public String process(JMSRequest request) {
        JMSSubscribeUserRequest jmsCommand = mapRequest(request, JMSSubscribeUserRequest.class);

        SubscribeUserCommand coreCommand = new SubscribeUserCommand(jmsCommand.getUserId());
        SubscribeUserResult coreResult = executeCoreCommand(coreCommand);

        JMSSubscribeUserResponse jmsResponse = new JMSSubscribeUserResponse();
        jmsResponse.setUser(coreResult.getUser());
        return buildPayload(jmsResponse);
    }

}
