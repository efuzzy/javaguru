package lv.javaguru.vika.app.database;
import lv.javaguru.vika.app.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long> {

}
