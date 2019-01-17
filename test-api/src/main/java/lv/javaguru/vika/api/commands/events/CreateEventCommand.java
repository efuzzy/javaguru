package lv.javaguru.vika.api.commands.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lv.javaguru.vika.api.commands.DomainCommand;
@AllArgsConstructor
@Getter
public class CreateEventCommand implements DomainCommand<CreateEventResult> {
    private String eventName;
}
