package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("번호가 1 이상, 45 이하가 아니라면 예외가 발생한다.")
    @ValueSource(ints = {0, -1, 46})
    void Number_IsOutOfRange_ThrowException(int num) {
        assertThatThrownBy(() -> new LottoNumber(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("1 이상, 45 이하여야 됩니다");
    }
}
