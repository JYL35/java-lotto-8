package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {

    @ParameterizedTest
    @DisplayName("구매 금액이 비어있으면 예외 발생")
    @NullAndEmptySource
    void test_구매_금액_공백_또는_널값_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 정수가 아니면 예외 발생")
    @ValueSource(strings = {"a", "abc", "1000.5", " 9"})
    void test_구매_금액_정수_아니면_예외발생(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]");
    }
}
