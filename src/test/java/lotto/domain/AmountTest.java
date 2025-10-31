package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100000;

    @ParameterizedTest
    @DisplayName("구매 금액이 비어있으면 예외 발생")
    @NullAndEmptySource
    void test_구매_금액_공백_또는_널값_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 정수가 아니면 예외 발생")
    @ValueSource(strings = {"a", "abc", "1000.5", " 9"})
    void test_구매_금액_정수_아니면_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("정수여야 합니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1천원 미만, 10만원 초과면 예외 발생")
    @ValueSource(strings = {"999", "0", "-1000", "100001"})
    void test_구매_금액_범위_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining(String.format(
                        "%,d원 이상, %,d원 미만이어야 합니다",
                        LOTTO_PRICE, MAX_PURCHASE_AMOUNT
                ));
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 1천원 단위가 아니면 예외 발생")
    @ValueSource(strings = {"1001", "12345", "99999", "50001"})
    void test_구매_금액_1천원_단위_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("%,d원 단위어야 합니다", LOTTO_PRICE);
    }
}
