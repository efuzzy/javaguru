package lv.javaguru.vika.api.commands.events;

import lv.javaguru.vika.api.commands.DomainCommand;

public class CreateEventCommand implements DomainCommand<CreateEventResult> {

    private String eventName;

    public CreateEventCommand(String eventId) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventName;
    }

}
