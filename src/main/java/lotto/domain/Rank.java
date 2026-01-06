package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000L, false),
    SECOND(5, 30_000_000L, true),
    THIRD(5, 1_500_000L, false),
    FOURTH(4, 50_000L, false),
    FIFTH(3, 5_000L, false),
    MISS(0, 0L, false),
    ;

    private final int matchCount;
    private final long prize;
    private final boolean bonusNumber;

    Rank(int matchCount, long prize, boolean bonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonusNumber = bonusNumber;
    }

    public static Rank findRank(int matchCount, boolean bonusNumber) {
        if (matchCount == Rank.SECOND.getMatchCount() && bonusNumber) {
            return Rank.SECOND;
        }
        for (Rank rank : Rank.values()) {
            if (rank.getMatchCount() == matchCount && !rank.isBonusNumber()) {
                return rank;
            }
        }
        throw new IllegalArgumentException("해당하는 순위가 없습니다.");
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean isBonusNumber() {
        return bonusNumber;
    }
}
