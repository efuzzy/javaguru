package lv.javaguru.vika.app.services.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.vika.app.database.EventRepository;
import lv.javaguru.vika.app.domain.Event;

@Component
class EventServiceImpl implements EventService {

    @Autowired private EventRepository eventRepository;
    //@Autowired private ClientValidator clientValidator;


    /*@Override
    public Client update(Long clientId,
                         String newLogin,
                         String newPassword) {
        clientValidator.validate(newLogin, newPassword);
        Client client = get(clientId);
        client.setLogin(newLogin);
        client.setPassword(newPassword);
        return client;
    }*/

    @Override
    public Event get(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}
