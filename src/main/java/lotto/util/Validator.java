package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Validator {
    private static final int PURCHASE_UNIT = 1000;

    public static int validatePurchaseAmount(String input) {
        validateEmpty(input, ErrorMessage.PURCHASE_AMOUNT_IS_EMPTY);
        int purchaseAmount = validateNumber(input, ErrorMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER);
        validateRange(PURCHASE_UNIT, 100000, purchaseAmount, ErrorMessage.PURCHASE_AMOUNT_OUT_OF_RANGE);
        validateUnit(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinningNumbers(List<String> inputs) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : inputs) {
            validateEmpty(input, ErrorMessage.WINNING_NUMBER_IS_EMPTY);
            int number = validateNumber(input, ErrorMessage.WINNING_NUMBER_IS_NOT_NUMBER);
            validateRange(1, 45, number, ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE);
            winningNumbers.add(number);
        }
        validateDuplicate(winningNumbers);
        validateNumberCount(winningNumbers);
        return winningNumbers;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        validateEmpty(input, ErrorMessage.BONUS_NUMBER_IS_EMPTY);
        int bonusNumber = validateNumber(input, ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER);
        validateRange(1, 45, bonusNumber, ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE);
        validateBonusNumberDuplicate(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void validateBonusNumberDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        List<Integer> comparison = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != comparison.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_IS_INCORRECT.getMessage());
        }
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

    private static void validateUnit(int input) {
        if (input % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_WRONG_UNIT.getMessage());
        }
    }
}
