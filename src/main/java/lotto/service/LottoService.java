package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoService {

    public List<Lotto> createLotto(int purchaseAmount) {
        int purchaseCount = calculatePurchaseCount(purchaseAmount);
        List<Lotto> lottoTickets = new ArrayList<>();
        while (purchaseCount-- != 0) {
            lottoTickets.add(new Lotto(createLottoNumber()));
        }
        return lottoTickets;
    }

    private int calculatePurchaseCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private List<Integer> createLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
