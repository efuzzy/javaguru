package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.database.EventRepository;
import lv.javaguru.vika.app.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class EventServiceImpl implements EventService {

    @Autowired private EventRepository eventRepository;

    @Override
    public Event get(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}
