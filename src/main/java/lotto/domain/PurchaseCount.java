package lotto.domain;

import lotto.constant.ErrorMessage;

public class PurchaseCount {
    private static final int PURCHASE_UNIT = 1_000;
    private static final int MAXIMUM_AMOUNT = 100_000;

    private final int purchaseAmount;
    private final int purchaseCount;

    public PurchaseCount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        validate();

        this. purchaseCount = purchaseAmount / PURCHASE_UNIT;
    }

    private void validate() {
        validateUnit();
        validateRange();
    }

    private void validateUnit() {
        if (purchaseAmount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_UNITS.getMessage());
        }
    }

    private void validateRange() {
        if (purchaseAmount < PURCHASE_UNIT || purchaseAmount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_OUT_OF_RANGE.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
