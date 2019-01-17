package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.app.database.UserRepository;
import lv.javaguru.vika.app.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public User get(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Long> getAllUsersIds() {
        List<Long> ret = new ArrayList<>();
        for(User user : userRepository.findAll()) {
            ret.add(user.getId());
        }
        return ret;
    }


}
