package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @ParameterizedTest
    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    void Lotto_sizeIsNot6_ThrowException(String lotto) {
        List<LottoNumber> numbers = Arrays.stream(lotto.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("6개여야 합니다");
    }

    @ParameterizedTest
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,2,3,4,5"})
    void Lotto_HasDuplicateNumbers_ThrowException(String lotto) {
        List<LottoNumber> numbers = Arrays.stream(lotto.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("중복");
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 오름차순으로 정렬된다.")
    @CsvSource(value = {"1,42,30,45,21,17:1,17,21,30,42,45",
            "45,40,35,30,25,20:20,25,30,35,40,45"},
            delimiter = ':')
    void Lotto_ToString_ReturnsSortedString(String input, String expected) {
        List<LottoNumber> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .toList();

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.toString()).isEqualTo(expected);
    }
}
