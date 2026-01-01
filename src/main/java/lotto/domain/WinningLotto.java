package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningLotto {

    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        List<LottoNumber> tempLotto = new ArrayList<>(winningLotto);
        tempLotto.add(bonusNumber);
        validateDuplication(winningLotto.size(), tempLotto);
        this.winningLotto = new Lotto(winningLotto);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplication(int winningNumberCount, List<LottoNumber> numbers) {
        List<LottoNumber> winningNum = numbers.stream().distinct().toList();

        if (winningNumberCount != winningNum.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
