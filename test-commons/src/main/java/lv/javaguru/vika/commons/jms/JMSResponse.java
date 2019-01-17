package lv.javaguru.vika.commons.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.javaguru.vika.commons.enums.ResponseStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JMSResponse {

    @JsonProperty("command_id")
    private String commandId;

    @JsonProperty("correlation_id")
    private String correlationId;

    @JsonProperty("response_status")
    private ResponseStatus responseStatus;

    @JsonProperty("payload")
    private String payload;

    public boolean isSuccess() {
        return ResponseStatus.SUCCESS.equals(responseStatus);
    }
}
