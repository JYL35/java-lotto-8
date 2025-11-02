package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchNumberCount;
    private final long prize;

    Rank(int matchNumberCount, long prize) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
    }

    public static Rank of(int matchNumberCount, boolean matchBonus) {
        if (matchNumberCount == FIRST.matchNumberCount) {
            return FIRST;
        }
        if (matchNumberCount == SECOND.matchNumberCount && matchBonus) {
            return SECOND;
        }
        if (matchNumberCount == THIRD.matchNumberCount) {
            return THIRD;
        }
        if (matchNumberCount == FOURTH.matchNumberCount) {
            return FOURTH;
        }
        if (matchNumberCount == FIFTH.matchNumberCount) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public long getPrize() {
        return prize;
    }
}
