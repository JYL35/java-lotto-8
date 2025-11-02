package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void CreateInputParser() {
        inputParser = new InputParser();
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 공백이거나 널값이면 예외가 발생한다.")
    @NullAndEmptySource
    void parseAmount_IsBlank_ThrowException(String input) {
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("비어있을 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 정수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"a", "abc", "1000.5", " 9"})
    void parseAmount_IsNotInteger_ThrowException(String input) {
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("정수여야 합니다");
    }
}
