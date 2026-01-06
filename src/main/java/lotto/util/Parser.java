package lotto.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    public static int parsePurchaseAmount(String input) {
        return Validator.validatePurchaseAmount(input);
    }

    public static List<Integer> parseWinningNumbers(String input) {
        return Validator.validateWinningNumbers(Arrays.stream(input.split(","))
                .map(String::strip)
                .toList());
    }
}
