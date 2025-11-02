package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("구매한 로또들의 순위를 판별하고 당첨 통계를 계산한다.")
    void Lottos_CalculateWinningStatistics_ReturnsLottoResult() {
        Lotto winningNumbers = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Lotto userLotto1 = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)
        ));
        Lotto userLotto2 = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(7), new LottoNumber(8)
        ));
        Lotto userLotto3 = new Lotto(List.of(
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
        ));
        Lotto userLotto4 = new Lotto(List.of(
                new LottoNumber(13), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
        ));

        Lottos myLotto = new Lottos(List.of(
                userLotto1, userLotto2, userLotto3, userLotto4));

        GameResult gameResult = myLotto.calculateWinningStatistics(winningLotto);

        assertThat(gameResult.getCount(Rank.FIRST)).isEqualTo(0);
        assertThat(gameResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(gameResult.getCount(Rank.THIRD)).isEqualTo(0);
        assertThat(gameResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(gameResult.getCount(Rank.FIFTH)).isEqualTo(0);
        assertThat(gameResult.getCount(Rank.MISS)).isEqualTo(2);
    }
}
