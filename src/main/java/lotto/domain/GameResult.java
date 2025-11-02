package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class GameResult {
    private final Map<Rank, Integer> statistics;

    public GameResult(Map<Rank, Integer> statistics){
        this.statistics = new EnumMap<>(statistics);
    }

    public int getTotalPrize() {
        int totalPrize = 0;

        for (Rank rank : Rank.values()) {
            int rankPrize = rank.getPrize() * getCount(rank);
            totalPrize += rankPrize;
        }

        return totalPrize;
    }

    public int getCount(Rank rank) {
        return statistics.getOrDefault(rank, 0);
    }
}
