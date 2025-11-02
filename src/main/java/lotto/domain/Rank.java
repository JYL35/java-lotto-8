package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchNumberCount;
    private final int prize;

    Rank(int matchNumberCount, int prize) {
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

    public int getPrize() {
        return prize;
    }
}
