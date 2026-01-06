package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) winningLotto.getNumbers()
                .stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
