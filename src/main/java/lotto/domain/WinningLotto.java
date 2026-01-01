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

    private void validateDuplication(Lotto winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
