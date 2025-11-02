package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L, "6개 일치"),
    SECOND(5, 30_000_000L, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000L, "5개 일치"),
    FOURTH(4, 50_000L, "4개 일치"),
    FIFTH(3, 5_000L, "3개 일치"),
    MISS(0, 0L, "");

    private final int matchNumberCount;
    private final long prize;
    private final String description;

    Rank(int matchNumberCount, long prize, String description) {
        this.matchNumberCount = matchNumberCount;
        this.prize = prize;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public long getPrize() {
        return prize;
    }
}
