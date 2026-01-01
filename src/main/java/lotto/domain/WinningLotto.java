package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningLotto {

    private List<LottoNumber> winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        List<LottoNumber> tempLotto = new ArrayList<>(winningLotto);
        tempLotto.add(bonusNumber);
        validateDuplication(tempLotto);
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        List<LottoNumber> winningNum = numbers.stream().distinct().toList();

        if (winningLotto.size() != winningNum.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
