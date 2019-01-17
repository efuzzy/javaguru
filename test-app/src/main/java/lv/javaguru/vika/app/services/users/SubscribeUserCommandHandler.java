package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.api.commands.users.SubscribeUserCommand;
import lv.javaguru.vika.api.commands.users.SubscribeUserResult;
import lv.javaguru.vika.app.domain.User;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class SubscribeUserCommandHandler
        implements DomainCommandHandler<SubscribeUserCommand, SubscribeUserResult> {

    @Autowired private UserFactory userFactory;
    @Autowired private UserConverter userConverter;

    SubscribeUserCommandHandler() {
    }

    @Override
    public SubscribeUserResult execute(SubscribeUserCommand command) {
        User user = userFactory.subscribe(command.getUserId());
        UserDTO userDTO = userConverter.convert(user);
        return new SubscribeUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return SubscribeUserCommand.class;
    }

}
