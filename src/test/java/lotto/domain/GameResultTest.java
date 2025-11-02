package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    @DisplayName("당첨 통계를 이용하여 총 당첨금을 계산한다.")
    void GameResult_GetTotalPrize_ReturnsCorrectPrize() {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        statistics.put(Rank.THIRD, 1);
        statistics.put(Rank.FIFTH, 2);
        GameResult result = new GameResult(statistics);

        int totalPrize = result.getTotalPrize();

        assertThat(totalPrize).isEqualTo(1510000);
    }
}
