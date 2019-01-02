package lv.javaguru.vika.api.commands.events;

import lv.javaguru.vika.api.commands.DomainCommandResult;
import lv.javaguru.vika.commons.dtos.EventDTO;

import java.util.List;

public class GetAllEventsResult implements DomainCommandResult {
    private List<EventDTO> events;

    public GetAllEventsResult( List<EventDTO> events) {
        this.events= events;
    }

    public  List<EventDTO> getEvents() {
        return events;
    }

}
