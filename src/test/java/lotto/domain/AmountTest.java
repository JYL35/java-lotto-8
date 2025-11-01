package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    @ParameterizedTest
    @DisplayName("구매 금액이 공백이거나 널값이면 예외가 발생한다.")
    @NullAndEmptySource
    void Amount_IsBlank_ThrowException(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 정수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"a", "abc", "1000.5", " 9"})
    void Amount_IsNotInteger_ThrowException(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("정수여야 합니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1천원 미만, 10만원 초과면 예외가 발생한다.")
    @ValueSource(strings = {"999", "0", "-1000", "100001"})
    void Amount_IsOutOfRange_ThrowException(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining(String.format(
                        "%,d원 이상, %,d원 이하여야 합니다",
                        LOTTO_PRICE, MAX_PURCHASE_AMOUNT
                ));
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1천원 단위가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1001", "12345", "99999", "50001"})
    void Amount_IsNotInUnit_ThrowException(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("%,d원 단위어야 합니다", LOTTO_PRICE);
    }

    @ParameterizedTest
    @DisplayName("구매 금액에 따라 알맞은 로또 개수를 반환한다.")
    @CsvSource(value = {"1000:1", "99000:99", "23000:23"}, delimiter = ':')
    void Amount_GetLottoPurchaseCount_ReturnsCorrectCount(String input, int expected) {
        Amount amount = new Amount(input);

        int lottoPurchaseCount = amount.getLottoPurchaseCount();

        assertThat(lottoPurchaseCount).isEqualTo(expected);
    }
}
