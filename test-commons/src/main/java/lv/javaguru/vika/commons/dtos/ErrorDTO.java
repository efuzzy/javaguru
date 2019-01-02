package lv.javaguru.vika.commons.dtos;

import lv.javaguru.vika.commons.enums.ErrorEmitter;

public class ErrorDTO {

    private String description;
    private ErrorEmitter emitter;
    private ErrorDTO errorCode;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorEmitter getEmitter() {
        return emitter;
    }

    public void setEmitter(ErrorEmitter emitter) {
        this.emitter = emitter;
    }

    public ErrorDTO getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorDTO errorCode) {
        this.errorCode = errorCode;
    }
}
