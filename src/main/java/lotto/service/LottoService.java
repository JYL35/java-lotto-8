package lotto.service;

import lotto.domain.Amount;
import lotto.domain.Lottos;

public class LottoService {
    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos purchaseLottos(Amount amount) {
        int purchaseCount = amount.getLottoPurchaseCount();

        return lottoGenerator.generate(purchaseCount);
    }
}
