package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.dto.GameResult;

public class LottoService {

    public List<Lotto> createLotto(int purchaseAmount) {
        int purchaseCount = calculatePurchaseCount(purchaseAmount);
        List<Lotto> lottoTickets = new ArrayList<>();
        while (purchaseCount-- != 0) {
            lottoTickets.add(new Lotto(createLottoNumber()));
        }
        return lottoTickets;
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumber, int bonusNumber) {
        return new WinningLotto(new Lotto(winningNumber), bonusNumber);
    }

    public GameResult calculateWinningStatistics(List<Lotto> lottoTickets,
                                                 WinningLotto winningLotto, int purchaseAmount) {
        Map<Rank, Integer> winningStatistics = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottoTickets) {
            int matchCount = winningLotto.calculateMatchCount(lotto);
            boolean matchBonus = winningLotto.matchBonusNumber(lotto);
            Rank rank = Rank.findRank(matchCount, matchBonus);
            winningStatistics.put(rank, winningStatistics.getOrDefault(rank, 0) + 1);
        }
        double profitRate = calculateProfitRate(winningStatistics, purchaseAmount);
        return new GameResult(winningStatistics, profitRate);
    }

    private double calculateProfitRate(Map<Rank, Integer> winningStatistics, int purchaseAmount) {
        long totalPrize = 0;
        for (Rank rank : Rank.values()) {
            long prize = rank.getPrize() * winningStatistics.getOrDefault(rank, 0);
            totalPrize += prize;
        }
        return (double) totalPrize / purchaseAmount;
    }

    private int calculatePurchaseCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
