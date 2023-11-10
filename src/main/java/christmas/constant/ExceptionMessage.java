package christmas.constant;

public enum ExceptionMessage {
    ERROR_INPUT_ORDER_MESSAGE("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ERROR_INPUT_NUMBER_TYPE_MESSAGE("숫자만 입력해주세요."),
    ERROR_INPUT_DATE_MESSAGE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
