package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.domain.Event;

public interface EventService {
	Event get(Long eventId);
}
