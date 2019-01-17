package lv.javaguru.vika.api.commands.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.dtos.UserDTO;

import java.util.List;

@AllArgsConstructor
@Getter
public class GetAllUsersResult implements DomainCommandResult {
    private List<UserDTO> users;
}
