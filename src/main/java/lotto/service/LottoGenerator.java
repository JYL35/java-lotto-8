package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

public class LottoGenerator {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos generate(int count) {
        List<Lotto> lottos = Stream.generate(this::createLotto)
                .limit(count)
                .toList();
        return new Lottos(lottos);
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,
                LOTTO_LAST_NUMBER,
                LOTTO_NUMBER_COUNT);

        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();

        return new Lotto(lottoNumbers);
    }
}
