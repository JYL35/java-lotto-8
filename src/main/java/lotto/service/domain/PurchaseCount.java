package lotto.service.domain;

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
        validateMaximum();
    }

    private void validateUnit() {
        if (purchaseAmount % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_UNITS.getMessage());
        }
    }

    private void validateMaximum() {
        if (purchaseAmount > MAXIMUM_AMOUNT) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MAXIMUM_AMOUNT.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
