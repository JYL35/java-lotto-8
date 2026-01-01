package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000L, false),
    FOURTH(4, 50_000L, false),
    THIRD(5, 1_500_000L, false),
    SECOND(5, 30_000_000L, true),
    FRIST(6, 2_000_000_000L, false),
    MISS(0, 0L, false);


    private int matchCount;
    private long winningAmount;
    private boolean matchBonus;

    public static Rank matchRank(int matchNumberCount, boolean matchBonusNum) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchNumberCount && rank.matchBonus == matchBonusNum)
                .findFirst()
                .orElse(MISS);
    }

    Rank(int matchCount, long winningAmount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public long totalPrize(int count) {
        return winningAmount * count;
    }
}
