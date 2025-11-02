package lotto.util;

public class InputParser {

    public int parseAmount(String inputAmount) {
        validateEmpty(inputAmount, ErrorMessage.AMOUNT_BLANK);
        return validateInteger(inputAmount, ErrorMessage.AMOUNT_NOT_INTEGER);
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
