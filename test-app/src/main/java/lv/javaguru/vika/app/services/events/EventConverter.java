package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.domain.Event;
import lv.javaguru.vika.commons.dtos.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {
    public EventDTO convert(Event event) {
        return EventDTO.builder().eventName(event.getEventName()).id(event.getId()).build();
    }
}
