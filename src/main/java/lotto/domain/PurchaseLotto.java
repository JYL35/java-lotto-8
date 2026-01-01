package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseLotto {

    private final List<Lotto> purchaseLotto;

    public PurchaseLotto(List<Lotto> purchaseLotto) {
        this.purchaseLotto = new ArrayList<>(purchaseLotto);
    }

    public int getLottoSize() {
        return purchaseLotto.size();
    }
}
