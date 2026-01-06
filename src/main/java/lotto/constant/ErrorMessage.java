package lotto.constant;

public enum ErrorMessage {
    PURCHASE_AMOUNT_IS_EMPTY("구매 금액이 비어있습니다."),
    PURCHASE_AMOUNT_IS_NOT_NUMBER("구매 금액이 숫자가 아닙니다."),
    PURCHASE_AMOUNT_OUT_OF_RANGE("구매 금액은 1000~100000이어야 합니다."),
    PURCHASE_AMOUNT_WRONG_UNIT("구매 금액은 1000원 단위어야 합니다."),

    LOTTO_NUMBER_IS_INCORRECT("로또 번호 개수는 6개어야 합니다."),
    LOTTO_NUMBER_IS_DUPLICATED("로또 번호가 중복됩니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1~45이어야 합니다."),


    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_FOUND_NICKNAME("등록되지 않은 닉네임입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
