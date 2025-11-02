package lotto.domain;

import lotto.util.ErrorMessage;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    private final int purchaseAmount;

    public Amount(int purchaseAmount) {
        validateRange(purchaseAmount);
        validateUnit(purchaseAmount);

        this.purchaseAmount = purchaseAmount;
    }

    public int getLottoPurchaseCount() {
        return purchaseAmount / LOTTO_PRICE;
    }

    public double getProfitRate(long totalPrize) {
        return (double) totalPrize / purchaseAmount * 100.0;
    }

    private void validateRange(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE || purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(String.format(
                    ErrorMessage.AMOUNT_OUT_OF_RANGE.getMessage(),
                    LOTTO_PRICE, MAX_PURCHASE_AMOUNT
            ));
        }
    }

    private void validateUnit(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(
                    ErrorMessage.AMOUNT_DIFFERENT_UNIT.getMessage(),
                    LOTTO_PRICE
            ));
        }
    }
}
