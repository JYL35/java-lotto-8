package lotto.domain;

import lotto.constant.ErrorMessage;

public class WinningLotto {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        validateDuplication(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank findRank(Lotto lotto) {
        int matchCount = lotto.matchCountOtherLotto(winningNumber);
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.matchRank(matchCount, matchBonus);
    }

    private void validateDuplication(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
