package lv.javaguru.vika.app.services.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.vika.app.database.EventRepository;
import lv.javaguru.vika.app.domain.Event;

import static lv.javaguru.vika.app.domain.EventBuilder.createEvent;
@Component
class EventFactoryImpl implements EventFactory {

    @Autowired private EventRepository eventRepository;

    @Override
    public Event create(String eventName) {
    	Event event = createEvent()
                .withEventName(eventName)
                .build();
        return eventRepository.save(event);
    }
    
    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
