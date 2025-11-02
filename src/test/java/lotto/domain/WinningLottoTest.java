package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningLottoTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @CsvSource(value = {"1,42,30,45,21,17:42",
            "45,40,35,30,25,20:20"}, delimiter = ':')
    void WinningLotto_DuplicateBonusNumber_ThrowException(String input, int number) {
        List<LottoNumber> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 객체가 생성된다.")
    @CsvSource(value = {"1,42,30,45,21,17:5",
            "45,40,35,30,25,20:15"}, delimiter = ':')
    void WinningLotto_ValidBonusNumber_CreateSuccess(String input, int number) {
        List<LottoNumber> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        Lotto winningLotto = new Lotto(winningNumbers);
        LottoNumber bonusNumber = new LottoNumber(number);

        assertDoesNotThrow(() -> new WinningLotto(winningLotto, bonusNumber));
    }
}
