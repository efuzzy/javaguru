package lv.javaguru.vika.api.commands.events;

import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.dtos.EventDTO;

public class CreateEventResult implements DomainCommandResult {

    private EventDTO event;

    public CreateEventResult(EventDTO event) {
        this.event = event;
    }

    public EventDTO getEvent() {
        return event;
    }

}
