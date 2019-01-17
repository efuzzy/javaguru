package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.app.domain.User;

import java.util.List;

public interface UserService {
	User get(Long userId);
	List<User> getAll();
	List<Long> getAllUsersIds();
}
