package lotto.view;

import java.util.List;

public class OutputView {

    public void printPurchaseLotto(List<String> formattedLotto) {
        formattedLotto.forEach(System.out::println);
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}

