package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        return userInput(INPUT_PURCHASE_AMOUNT);
    }

    public String inputWinningNumbers() {
        return userInput(INPUT_WINNING_NUMBERS);
    }

    public String inputBonusNumber() {
        return userInput(INPUT_BONUS_NUMBER);
    }

    private String userInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
