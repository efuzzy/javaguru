package lv.javaguru.vika.api.commands.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lv.javaguru.vika.api.commands.DomainCommand;

@AllArgsConstructor
@Getter
public class GetUserCommand implements DomainCommand<GetUserResult> {

    private Long eventId;
}
