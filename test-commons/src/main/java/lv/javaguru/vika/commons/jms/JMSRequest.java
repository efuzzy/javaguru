package lv.javaguru.vika.commons.jms;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JMSRequest {

    @JsonProperty("command_id")
    private String commandId;

    @JsonProperty("correlation_id")
    private String correlationId;

    @JsonProperty("payload")
    private String payload;
}
