package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    public int parseAmount(String inputAmount) {
        validateEmpty(inputAmount, ErrorMessage.AMOUNT_BLANK);
        return validateInteger(inputAmount, ErrorMessage.AMOUNT_NOT_INTEGER);
    }

    public List<Integer> parseWinningNumbers(String inputWinningNumbers) {
        validateSeparator(inputWinningNumbers, ErrorMessage.WINNING_NUMBER_ENDS_WITH_SEPARATOR);

        return Arrays.stream(inputWinningNumbers.split(","))
                .map(numberStr -> validateInteger(numberStr, ErrorMessage.WINNING_NOT_INTEGER))
                .toList();
    }

    private void validateSeparator(String input, ErrorMessage error) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private void validateEmpty(String input, ErrorMessage error) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }

    private int validateInteger(String input, ErrorMessage error) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error.getMessage());
        }
    }
}
