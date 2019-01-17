package lv.javaguru.vika.api.commands.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.dtos.UserDTO;

@AllArgsConstructor
@Getter
public class SubscribeUserResult implements DomainCommandResult {
    private UserDTO user;
}
