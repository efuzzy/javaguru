package lv.javaguru.vika.commons.dtos;

public class EventDTOBuilder {

    private Long id;
    private String eventName;

    private EventDTOBuilder() {

    }

    public static EventDTOBuilder createEventDTO() {
        return new EventDTOBuilder();
    }

    public EventDTO build() {
        EventDTO event = new EventDTO();
        event.setId(id);
        event.setEventName(eventName);
        return event;
    }

    public EventDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EventDTOBuilder withEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

}
