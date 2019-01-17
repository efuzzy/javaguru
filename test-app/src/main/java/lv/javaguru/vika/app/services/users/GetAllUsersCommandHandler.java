package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.api.commands.users.GetAllUsersCommand;
import lv.javaguru.vika.api.commands.users.GetAllUsersResult;
import lv.javaguru.vika.app.domain.User;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class GetAllUsersCommandHandler
        implements DomainCommandHandler<GetAllUsersCommand, GetAllUsersResult> {

    @Autowired private UserService userService;
    @Autowired private UserConverter userConverter;

    GetAllUsersCommandHandler() {
    }

    @Override
    public GetAllUsersResult execute(GetAllUsersCommand command) {
        List<User> users = userService.getAll();
        List<UserDTO> userDTOs = userConverter.convertAll(users);
        return new GetAllUsersResult(userDTOs);
    }

    @Override
    public Class getCommandType() {
        return GetAllUsersCommand.class;
    }

}
