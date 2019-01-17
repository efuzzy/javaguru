package lv.javaguru.vika.app.database;

import lv.javaguru.vika.app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query("update User u set subscribed = ?2 where u.id = ?1")
    void update(Long userId, boolean subscribe);
}
