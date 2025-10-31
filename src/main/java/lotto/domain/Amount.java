package lotto.domain;

public class Amount {

    public Amount(String purchaseAmount) {
        validateEmpty(purchaseAmount);
        int parsedAmount = validateInteger(purchaseAmount);
    }

    private void validateEmpty(String purchaseAmount) {
        if (purchaseAmount == null || purchaseAmount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 비어있을 수 없습니다. 다시 입력해주세요.");
        }
    }

    private int validateInteger(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 정수여야 합니다. 다시 입력해주세요.");
        }
    }
}
