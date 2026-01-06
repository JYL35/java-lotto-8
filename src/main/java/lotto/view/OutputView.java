package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.GameResult;

public class OutputView {

    public void printLottoTickets(List<Lotto> lottoTickets) {
        printNewLine();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            String lottoNumbers = String.join(", ", lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .toList());
            System.out.println("[" + lottoNumbers + "]");
        }
        printNewLine();
    }

    public void printResult(GameResult gameResult) {
        System.out.printf("3개 일치 (5,000원) - %d개", gameResult.result().getOrDefault(Rank.FIFTH, 0));
        printNewLine();
        System.out.printf("4개 일치 (50,000원) - %d개", gameResult.result().getOrDefault(Rank.FOURTH, 0));
        printNewLine();
        System.out.printf("5개 일치 (1,500,000원) - %d개", gameResult.result().getOrDefault(Rank.THIRD, 0));
        printNewLine();
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", gameResult.result().getOrDefault(Rank.SECOND, 0));
        printNewLine();
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", gameResult.result().getOrDefault(Rank.FIRST, 0));
        printNewLine();
        System.out.println("총 수익률은 " + String.format("%.1f", gameResult.profitRate()) + "%입니다.");
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
