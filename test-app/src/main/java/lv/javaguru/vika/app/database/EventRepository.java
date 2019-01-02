package lv.javaguru.vika.app.database;
import org.springframework.data.jpa.repository.JpaRepository;

import lv.javaguru.vika.app.domain.Event;



public interface EventRepository extends JpaRepository<Event, Long> {

}
