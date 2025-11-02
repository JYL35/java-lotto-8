package lotto.domain;

import lotto.util.ErrorMessage;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    public Rank matchRank(Lotto userLotto) {
        int matchNumberCount = winningLotto.matchCountOtherLottoNumber(userLotto);
        boolean matchBonus = userLotto.contains(bonusNumber);

        return Rank.of(matchNumberCount, matchBonus);
    }
}
