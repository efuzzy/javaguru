package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.app.domain.Event;

public interface EventService {

	/*Event update(Long clientId,
                  String newLogin,
                  String newPassword);*/

	Event get(Long eventId);

}
