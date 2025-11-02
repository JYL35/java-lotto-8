package lotto.util;

public class InputParser {

    public int parseAmount(String inputAmount) {
        validateEmpty(inputAmount);
        return validateInteger(inputAmount);
    }

    private void validateEmpty(String inputAmount) {
        if (inputAmount == null || inputAmount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 비어있을 수 없습니다. 다시 입력해주세요.");
        }
    }

    private int validateInteger(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수여야 합니다. 다시 입력해주세요.");
        }
    }
}
