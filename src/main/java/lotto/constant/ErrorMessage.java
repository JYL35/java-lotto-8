package lotto.constant;

public enum ErrorMessage {

    WRONG_UNITS("1,000원 단위가 아닙니다."),
    OVER_MAXIMUM_AMOUNT("최대 금액인 100,000원을 넘겼습니다."),
    NUMBER_OUT_OF_RANGE("번호가 1~45가 아닙니다.");

    private static final String PREFIX = "[ERROR] ";
    private static final String TRY_AGAIN = " 다시 입력해주세요.";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message + TRY_AGAIN;
    }
}
