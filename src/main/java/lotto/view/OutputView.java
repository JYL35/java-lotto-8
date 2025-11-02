package lotto.view;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Rank;
import lotto.util.ErrorMessage;

public class OutputView {
    private static final String PRINT_PURCHASE_COUNT = "\n%d개를 구매했습니다.";
    private static final String PRINT_STATISTICS_HEADER = "\n당첨 통계";
    private static final String PRINT_SEPARATION = "---";
    private static final String PRINT_STATISTICS_LINE = "%s (%,d원) - %d개";
    private static final String PRINT_PROFIT_RATE = "총 수익률은 %,.1f%%입니다.";

    public void printError(String errorMessage) {
        System.out.println(errorMessage + ErrorMessage.TRY_AGAIN.getMessage() + "\n");
    }

    public void printPurchaseCount(int count) {
        System.out.println(String.format(PRINT_PURCHASE_COUNT, count));
    }

    public void printPurchaseLottos(List<String> formattedLottos) {
        formattedLottos.forEach(System.out::println);
    }

    public void printStatisticsHeader() {
        System.out.println(PRINT_STATISTICS_HEADER);
        System.out.println(PRINT_SEPARATION);
    }

    public void printStatistics(GameResult gameResult) {
        for (Rank rank : Rank.values()) {
            System.out.println(String.format(
                    PRINT_STATISTICS_LINE,
                    rank.getDescription(),
                    rank.getPrize(),
                    gameResult.getCount(rank)
            ));
        }
    }

    public void printProfitRate(double profitRate) {
        System.out.println(String.format(PRINT_PROFIT_RATE, profitRate));
    }
}
