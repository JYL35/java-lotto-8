package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public GameResult calculateWinningStatistics(WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.matchRank(lotto);

            statistics.put(rank, statistics.get(rank) + 1);
        }

        return new GameResult(statistics);
    }
}
