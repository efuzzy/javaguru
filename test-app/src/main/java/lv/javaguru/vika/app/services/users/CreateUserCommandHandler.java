package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.api.commands.users.CreateUserCommand;
import lv.javaguru.vika.api.commands.users.CreateUserResult;
import lv.javaguru.vika.app.domain.User;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class CreateUserCommandHandler
        implements DomainCommandHandler<CreateUserCommand, CreateUserResult> {

    @Autowired private UserFactory userFactory;
    @Autowired private UserConverter userConverter;

    CreateUserCommandHandler() {
    }

    @Override
    public CreateUserResult execute(CreateUserCommand command) {
        User user = userFactory.create(command.getUserName(), command.getUserEmail());
        UserDTO userDTO = userConverter.convert(user);
        return new CreateUserResult(userDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateUserCommand.class;
    }

}
