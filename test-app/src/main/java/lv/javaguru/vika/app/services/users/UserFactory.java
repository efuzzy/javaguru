package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.app.domain.User;

public interface UserFactory {

    User create(String userName, String userEmail);

    User subscribe(Long userId);
}
