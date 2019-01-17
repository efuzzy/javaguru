package lv.javaguru.vika.api.commands.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lv.javaguru.vika.api.commands.DomainCommand;
@AllArgsConstructor
@Data
public class CreateUserCommand implements DomainCommand<CreateUserResult> {
    private String userName;
    private String userEmail;


}
