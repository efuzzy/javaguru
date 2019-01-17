package lv.javaguru.vika.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User extends BaseEntity {
	@Id
	@GeneratedValue(generator = "users_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_gen", sequenceName = "users_seq", allocationSize = 1, initialValue = 2)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name="user_name", nullable = false)
    private String userName;
	@Column(name="user_email", nullable = false)
	private String userEmail;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name="subscribed", nullable = false, columnDefinition = "TINYINT")
    private boolean subscribed;
}