package lotto.constant;

public enum ErrorMessage {

    WRONG_UNITS("1,000원 단위가 아닙니다."),
    AMOUNT_OUT_OF_RANGE("금액이 1000~100000이 아닙니다."),
    NUMBER_OUT_OF_RANGE("번호가 1~45가 아닙니다."),
    LOTTO_NUMBER_COUNT_OVER("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호가 중복됩니다."),
    IS_EMPTY("빈 값입니다."),
    IS_NOT_NUMBER("숫자가 아닙니다.");

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
