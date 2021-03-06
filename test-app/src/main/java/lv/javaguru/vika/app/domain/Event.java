package lv.javaguru.vika.app.domain;

import javax.persistence.*;

@Entity
@Table(name="event")
public class Event extends BaseEntity {
 

	@Id
	@GeneratedValue(generator = "events_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "events_gen", sequenceName = "events_seq", allocationSize = 1)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="event_name", nullable = false)
    private String eventName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
    
}