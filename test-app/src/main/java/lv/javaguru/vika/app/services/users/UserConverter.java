package lv.javaguru.vika.app.services.users;

import lv.javaguru.vika.app.domain.User;
import lv.javaguru.vika.commons.dtos.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserDTO convert(User user) {
        return UserDTO.builder().name(user.getUserName()).email(user.getUserEmail()).id(user.getId()).subscribed(user.isSubscribed()).build();
    }

    public List<UserDTO> convertAll(List<User> users) {
        List<UserDTO> ret = new ArrayList<>();
        for (User user : users) {
            ret.add(UserDTO.builder().name(user.getUserName()).email(user.getUserEmail()).id(user.getId()).build());
        }
        return ret;
    }
}
