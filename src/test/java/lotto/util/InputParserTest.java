package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
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
                .hasMessageContaining("구매 금액은 비어있을 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("구매 금액이 정수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"a", "abc", "1000.5"})
    void parseAmount_IsNotInteger_ThrowException(String input) {
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("구매 금액은 정수여야 합니다");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 문자열을 쉼표(,)로 분리하여 List<Integer>로 반환한다")
    @ValueSource(strings = {"1,42,30,45,21,17", "45,40,35,30,25,20"})
    void parseWinningNumbers_ValidInput_ReturnsIntegerList(String input) {
        List<Integer> expected = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        List<Integer> result = inputParser.parseWinningNumbers(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 문자열 맨 뒤에 쉼표가 있을 경우 예외가 발생한다.")
    @ValueSource(strings = {"45,40,35,30,25,20,", "1,2,3,4,5,6,"})
    void parseWinningNumbers_SeparatorAtTheEnd_ThrowException(String input) {
        assertThatThrownBy(() -> inputParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("당첨 번호는 쉼표(,)로 끝날 수 없습니다");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호에 정수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"1,2,a,4,5,6", "1,2,,4,5,6", ",1,2,3,4,5"})
    void parseWinningNumbers_InvalidCharacter_ThrowException(String input) {
        assertThatThrownBy(() -> inputParser.parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("당첨 번호는 정수여야");
    }
}
