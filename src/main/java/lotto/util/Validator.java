package lotto.util;

import lotto.constant.ErrorMessage;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        validateEmpty(input, ErrorMessage.PURCHASE_AMOUNT_IS_EMPTY);
        int purchaseAmount = validateNumber(input, ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER);
        validateRange(1000, 100000, purchaseAmount, ErrorMessage.PURCHASE_AMOUNT_OUT_OF_RANGE);
        validateUnit(purchaseAmount, 1000, ErrorMessage.PURCHASE_AMOUNT_WRONG_UNIT);
        return purchaseAmount;
    }

    private static void validateEmpty(String input, ErrorMessage errorMessage) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static int validateNumber(String input, ErrorMessage errorMessage) {
        try {
            return Integer.parseInt(input.strip());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static void validateRange(int min, int max, int input, ErrorMessage errorMessage) {
        if (input < min || input > max) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    private static void validateUnit(int input, int unit, ErrorMessage errorMessage) {
        if (input % unit != 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }
}
