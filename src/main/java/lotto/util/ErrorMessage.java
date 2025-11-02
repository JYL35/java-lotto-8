package lotto.util;

public enum ErrorMessage {
    AMOUNT_BLANK("[ERROR] 구매 금액은 비어있을 수 없습니다."),
    AMOUNT_NOT_INTEGER("[ERROR] 구매 금액은 정수여야 합니다."),
    WINNING_NUMBER_ENDS_WITH_SEPARATOR("[ERROR] 당첨 번호는 쉼표(,)로 끝날 수 없습니다."),
    WINNING_BLANK("[ERROR] 당첨 번호는 비어있을 수 없습니다."),
    WINNING_NOT_INTEGER("[ERROR] 당첨 번호는 정수여야 합니다."),
    TRY_AGAIN("다시 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
