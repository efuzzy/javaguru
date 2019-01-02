package lv.javaguru.vika.app.domain;


public class EventBuilder {

    private Long id;
    private String eventName;


    private EventBuilder() {

    }

    public static EventBuilder createEvent() {
        return new EventBuilder();
    }

    public Event build() {
    	Event event = new Event();
        event.setId(id);
        event.setEventName(eventName);
        return event;
    }
    
    public EventBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public EventBuilder withEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }
}
