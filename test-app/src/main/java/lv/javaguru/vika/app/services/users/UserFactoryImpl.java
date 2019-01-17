package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.app.database.UserRepository;
import lv.javaguru.vika.app.domain.User;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
class UserFactoryImpl implements UserFactory {
    private static final Logger log = getLogger(UserFactoryImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(String name, String email) {
        return userRepository.save(User.builder().userEmail(email).userName(name).build());
    }

    @Override
    public User subscribe(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            user = User.builder().userEmail("viktorija@epasaule.lv").userName("vika auto").build();
            user = userRepository.save(user);
            log.debug("no user with id:" + userId + " Created a ne one:" + user.getId());
        }
        user.setSubscribed(true);
        userRepository.update(user.getId(), true);
        return user;
    }

}
