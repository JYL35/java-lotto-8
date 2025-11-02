package lotto.util;

public enum ErrorMessage {
    AMOUNT_BLANK("[ERROR] 구매 금액은 비어있을 수 없습니다."),
    AMOUNT_NOT_INTEGER("[ERROR] 구매 금액은 정수여야 합니다."),
    AMOUNT_OUT_OF_RANGE("[ERROR] 구매 금액은 %,d원 이상, %,d원 이하여야 합니다."),
    AMOUNT_DIFFERENT_UNIT("[ERROR] 구매 금액은 %,d원 단위어야 합니다."),
    LOTTO_NUMBER_COUNT_INCORRECT("[ERROR] 로또 번호는 %d개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호가 중복됩니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 번호는 %,d 이상, %,d 이하여야 됩니다. 다시 입력해주세요."),
    WINNING_NUMBER_ENDS_WITH_SEPARATOR("[ERROR] 당첨 번호는 쉼표(,)로 끝날 수 없습니다."),
    WINNING_BLANK("[ERROR] 당첨 번호는 비어있을 수 없습니다."),
    WINNING_NOT_INTEGER("[ERROR] 당첨 번호는 정수여야 합니다."),
    BONUS_NUMBER_BLANK("[ERROR] 보너스 번호는 비어있을 수 없습니다."),
    BONUS_NUMBER_NOT_INTEGER("[ERROR] 보너스 번호는 정수여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    TRY_AGAIN(" 다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
