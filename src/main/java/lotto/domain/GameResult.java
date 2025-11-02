package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class GameResult {
    private final Map<Rank, Integer> statistics;

    public GameResult(Map<Rank, Integer> statistics){
        this.statistics = new EnumMap<>(statistics);
    }
}
