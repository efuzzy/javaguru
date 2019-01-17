package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.api.commands.users.GetUserCommand;
import lv.javaguru.vika.api.commands.users.GetUserResult;
import lv.javaguru.vika.app.domain.User;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetUserCommandHandler
        implements DomainCommandHandler<GetUserCommand, GetUserResult> {

    @Autowired private UserService userService;
    @Autowired private UserConverter userConverter;

    GetUserCommandHandler() {
    }

    @Override
    public GetUserResult execute(GetUserCommand command) {
        User user = userService.get(command.getEventId());
        UserDTO userDTO = userConverter.convert(user);
        return new GetUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return GetUserCommand.class;
    }

}
