package lotto.util;

public class Parser {

    public static int parsePurchaseAmount(String input) {
        return Validator.validatePurchaseAmount(input);
    }
}
