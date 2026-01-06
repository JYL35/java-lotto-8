package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        validateEmpty(input);
        return validateNumber(input);
    }

    public static List<Integer> validateWinningNumber(String input) {
        return Arrays.stream(input.split(","))
                .map(Validator::validateNumber)
                .toList();
    }

    public static int validateBounusNumber(String input) {
        validateEmpty(input);
        return validateNumber(input);
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getMessage());
        }
    }

    private static int validateNumber(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
    }
}
