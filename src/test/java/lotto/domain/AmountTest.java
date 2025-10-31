package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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
}
