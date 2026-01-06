package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            String lottoNumbers = String.join(", ", lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .toList());
            System.out.println("[" + lottoNumbers + "]");
        }
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
