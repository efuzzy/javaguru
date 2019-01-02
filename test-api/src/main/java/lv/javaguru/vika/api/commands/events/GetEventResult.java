package lv.javaguru.vika.api.commands.events;

import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.dtos.EventDTO;

public class GetEventResult implements DomainCommandResult {

    private EventDTO event;

    public GetEventResult(EventDTO event) {
        this.event = event;
    }

    public EventDTO getEvent() {
        return event;
    }

}
