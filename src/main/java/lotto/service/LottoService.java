package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseCount;
import lotto.domain.PurchaseLotto;

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

    private Lotto createStrategy() {
        return new Lotto(Randoms
                .pickUniqueNumbersInRange(MAXIMUM_RANGE, MINIMUM_RANGE, LOTTO_COUNT)
                .stream()
                .map(LottoNumber::new)
                .toList());
    }
}
