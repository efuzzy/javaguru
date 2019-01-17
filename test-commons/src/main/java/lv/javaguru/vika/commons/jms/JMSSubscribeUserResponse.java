package lv.javaguru.vika.commons.jms;

import lombok.Data;
import lv.javaguru.vika.commons.dtos.UserDTO;

@Data
public class JMSSubscribeUserResponse {
    private UserDTO user;
}
