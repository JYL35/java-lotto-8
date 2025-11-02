package lotto.servcie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoGeneratorTest {

    @ParameterizedTest
    @DisplayName("요청 개수만큼 로또를 생성하여 Lottos 일급 컬렉션으로 반환한다.")
    @CsvSource(value = {"1:1", "99:99", "23:23"}, delimiter = ':')
    void LottoGenerator_Generate_ReturnsLottosWithCorrectCount(int count, int expected) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = lottoGenerator.generate(count);

        assertThat(lottos.getLottoCount()).isEqualTo(expected);
    }
}
