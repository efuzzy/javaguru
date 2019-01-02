package lv.javaguru.vika.api.commands.events;

import lv.javaguru.vika.api.commands.DomainCommand;

public class GetEventCommand implements DomainCommand<GetEventResult> {

    private Long eventId;

    public GetEventCommand(Long eventId) {
        this.eventId = eventId;
    }

    public Long getEventId() {
        return eventId;
    }

}
