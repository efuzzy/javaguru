package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.domain.Event;

public interface EventFactory {

    Event create(String eventName);
	Event getEventById(Long id);

}
