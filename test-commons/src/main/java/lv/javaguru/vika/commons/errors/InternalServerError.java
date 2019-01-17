package lv.javaguru.vika.commons.errors;

import lv.javaguru.vika.commons.enums.ResponseStatus;

public class InternalServerError extends ApplicationException {

    public InternalServerError() {
        super(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
