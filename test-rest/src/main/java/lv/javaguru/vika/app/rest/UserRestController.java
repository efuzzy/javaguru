package lv.javaguru.vika.app.rest;

import lv.javaguru.vika.api.CommandExecutor;
import lv.javaguru.vika.api.commands.users.*;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(
        value = "/users",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class UserRestController {

    private CommandExecutor commandExecutor;

    @Autowired
    public UserRestController(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @RequestMapping(method = RequestMethod.POST, value="/add")
    @ResponseBody
    public UserDTO create(UserDTO userDTO) {
        CreateUserCommand command = new CreateUserCommand(
                userDTO.getName(), userDTO.getEmail()
        );
        CreateUserResult result = commandExecutor.execute(command);
        return result.getUser();
    }

    @GetMapping("/get/{userId}")
    @ResponseBody
    public UserDTO get(@PathVariable("userId") Long userId) {
        GetUserCommand command = new GetUserCommand(userId);
        GetUserResult result = commandExecutor.execute(command);
        return result.getUser();
    }

    @GetMapping("/get")
    @ResponseBody
    public List<UserDTO> getAllUsers() {
        GetAllUsersCommand command = new GetAllUsersCommand();
        GetAllUsersResult result = commandExecutor.execute(command);
        return result.getUsers();
    }

}
