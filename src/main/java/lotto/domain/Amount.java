package lotto.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    private final int purchaseAmount;

    public Amount(int purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
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

    public int getLottoPurchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
