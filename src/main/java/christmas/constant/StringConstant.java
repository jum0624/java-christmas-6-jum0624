package christmas.constant;

public enum StringConstant {
    REGEX ("^[0-9가-힣-]*$"),
    COMMA(","),
    HYPHEN("-");

    private String message;

    StringConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
