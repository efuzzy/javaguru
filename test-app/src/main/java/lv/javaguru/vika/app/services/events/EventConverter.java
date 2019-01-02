package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.domain.Event;
import lv.javaguru.vika.commons.dtos.EventDTO;
import org.springframework.stereotype.Component;

import static lv.javaguru.vika.commons.dtos.EventDTOBuilder.createEventDTO;

@Component
public class EventConverter {
    public EventDTO convert(Event event) {
        return createEventDTO().withEventName(event.getEventName()).withId(event.getId()).build();
    }
}
