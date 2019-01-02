package lv.javaguru.vika.commons.enums;

public enum ErrorCode {

    VALIDATION_INVALID_FIELD_VALUE(Category.VALIDATION, Code.INVALID_FIELD_VALUE),
    VALIDATION_MISSING_FIELD(Category.VALIDATION, Code.MISSING_FIELD),
    VALIDATION_OPERATION_ERROR(Category.VALIDATION, Code.OPERATION_FAILED);

    ErrorCode(Category category, Code code) {
        this.category = category;
        this.code = code;
    }

    private Category category;
    private Code code;

    public enum Category {
        VALIDATION,
        INTERNAL
    }

    public enum Code {
        INVALID_FIELD_VALUE,
        MISSING_FIELD,
        OPERATION_FAILED
    }

    public Category getCategory() {
        return category;
    }

    public Code getCode() {
        return code;
    }
}
