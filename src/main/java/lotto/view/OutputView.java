package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PRINT_PURCHASE_COUNT = "개를 구매했습니다.";

    public void printPurchaseCount(int purchaseCount) {
        printNewLine();
        System.out.println(purchaseCount + PRINT_PURCHASE_COUNT);
    }

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

