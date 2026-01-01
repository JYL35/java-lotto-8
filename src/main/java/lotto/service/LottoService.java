package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseCount;
import lotto.domain.PurchaseLotto;
import lotto.domain.WinningLotto;

public class LottoService {
    private static final int MAXIMUM_RANGE = 45;
    private static final int MINIMUM_RANGE = 1;
    private static final int LOTTO_COUNT = 6;

    private PurchaseCount purchaseCount;

    public PurchaseLotto createLottos(int purchaseAmount) {
        purchaseCount = new PurchaseCount(purchaseAmount);

        return new PurchaseLotto(Stream.generate(this::createStrategy)
                .limit(purchaseCount.getPurchaseCount())
                .toList());
    }

    public WinningLotto createWinningLotto(List<Integer> numbers, int bonusNumber) {
        List<LottoNumber> winningNumber = numbers.stream()
                .map(LottoNumber::new)
                .toList();
        return new WinningLotto(winningNumber, new LottoNumber(bonusNumber));
    }

    private Lotto createStrategy() {
        return new Lotto(Randoms
                .pickUniqueNumbersInRange(MINIMUM_RANGE, MAXIMUM_RANGE, LOTTO_COUNT)
                .stream()
                .map(LottoNumber::new)
                .toList());
    }
}
