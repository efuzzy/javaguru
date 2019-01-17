package lv.javaguru.vika.app.services.events;

import lv.javaguru.vika.api.errors.CoreValidationError;
import lv.javaguru.vika.commons.enums.ErrorCode;
import lv.javaguru.vika.commons.enums.ErrorEmitter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EventValidatorImpl implements EventValidator {

    @Override
    public void validate(String eventName) {
        if(StringUtils.isEmpty(eventName)) {
            throw new CoreValidationError(ErrorCode.VALIDATION_MISSING_FIELD, "event name", ErrorEmitter.REST);
        }
    }


}
