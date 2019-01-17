package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.api.commands.events.CreateEventCommand;
import lv.javaguru.vika.api.commands.events.CreateEventResult;
import lv.javaguru.vika.app.domain.Event;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.app.services.users.UserService;
import lv.javaguru.vika.commons.dtos.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CreateEventCommandHandler
        implements DomainCommandHandler<CreateEventCommand, CreateEventResult> {

    @Autowired private EventFactory eventFactory;
    @Autowired private EventConverter eventConverter;
    @Autowired private UserService userService;

    CreateEventCommandHandler() {
    }

    @Override
    public CreateEventResult execute(CreateEventCommand command) {
        Event event = eventFactory.create(command.getEventName());
        EventDTO eventDTO = eventConverter.convert(event);
        List<Long> users = userService.getAllUsersIds();

        return new CreateEventResult(eventDTO);
    }

    @Override
    public Class getCommandType() {
        return CreateEventCommand.class;
    }

}
