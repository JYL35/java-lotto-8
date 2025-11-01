package lotto.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    public Amount(String purchaseAmount) {
        validateEmpty(purchaseAmount);
        int parsedAmount = validateInteger(purchaseAmount);
        validateRange(parsedAmount);
        validateUnit(parsedAmount);
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

    private void validateRange(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(String.format(
                    "[ERROR] 구매 금액은 %,d원 이상, %,d원 이하여야 합니다. 다시 입력해주세요.",
                    LOTTO_PRICE, MAX_PURCHASE_AMOUNT
            ));
        }
    }

    private void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(
                    "[ERROR] 구매 금액은 %,d원 단위어야 합니다. 다시 입력해주세요.",
                    LOTTO_PRICE
            ));
        }
    }
}
