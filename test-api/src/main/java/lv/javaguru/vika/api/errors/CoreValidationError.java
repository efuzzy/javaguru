package lv.javaguru.vika.api.errors;

import lv.javaguru.vika.commons.enums.ErrorCode;
import lv.javaguru.vika.commons.enums.ErrorEmitter;
import org.springframework.stereotype.Component;

public class CoreValidationError extends RuntimeException {

    private ErrorCode errorCode;
    private String description;
    private ErrorEmitter errorEmitter;

    public CoreValidationError(ErrorCode errorCode,
                               String description,
                               ErrorEmitter errorEmitter) {
        this.errorCode = errorCode;
        this.description = description;
        this.errorEmitter = errorEmitter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public ErrorEmitter getErrorEmitter() {
        return errorEmitter;
    }

}
