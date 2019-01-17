package lv.javaguru.vika.commons.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JMSSubscribeUserRequest implements JMSAPIRequest {
    @JsonProperty("userId")
    private Long userId;

    @Override
    public String getCommandId() {
        return SupportedCommandId.SUBSCRIBE;
    }
}
