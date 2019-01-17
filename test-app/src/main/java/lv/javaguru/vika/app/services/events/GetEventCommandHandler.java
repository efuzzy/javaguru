package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.api.commands.events.GetEventCommand;
import lv.javaguru.vika.api.commands.events.GetEventResult;
import lv.javaguru.vika.app.domain.Event;
import lv.javaguru.vika.app.services.DomainCommandHandler;
import lv.javaguru.vika.commons.dtos.EventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class GetEventCommandHandler
        implements DomainCommandHandler<GetEventCommand, GetEventResult> {

    @Autowired private EventService eventService;
    @Autowired private EventConverter eventConverter;

    GetEventCommandHandler() {
    }

    @Override
    public GetEventResult execute(GetEventCommand command) {
        Event event = eventService.get(command.getEventId());
        EventDTO clientDTO = eventConverter.convert(event);
        return new GetEventResult(clientDTO);
    }

    @Override
    public Class getCommandType() {
        return GetEventCommand.class;
    }

}
