package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
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

    @ParameterizedTest
    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 순위를 반환한다.")
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,8:THIRD",
            "1,2,3,4,7,8:FOURTH",
            "1,2,3,4,8,9:FOURTH",
            "1,2,3,7,8,9:FIFTH",
            "1,2,3,8,9,10:FIFTH",
            "1,2,7,8,9,10:MISS",
            "1,2,8,9,10,11:MISS",
            "1,7,8,9,10,11:MISS",
            "1,8,9,10,11,12:MISS",
            "7,8,9,10,11,12:MISS",
            "8,9,10,11,12,13:MISS"
    }, delimiter = ':')
    void WinningLotto_MatchRank_ReturnsCorrectRank(String lottoNumbers, Rank expectedRank) {
        Lotto winningNumbers = new Lotto(List.of(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        List<LottoNumber> lottoNums = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();
        Lotto userLotto = new Lotto(lottoNums);

        Rank rank = winningLotto.matchLank(userLotto);

        assertThat(rank).isEqualTo(expectedRank);
    }
}
