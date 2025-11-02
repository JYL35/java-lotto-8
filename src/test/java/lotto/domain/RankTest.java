package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RankTest {

    @ParameterizedTest
    @DisplayName("일치 개수와 보너스 여부에 따라 올바른 순위를 반환한다.")
    @CsvSource({
            "6,false,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "4,false,FOURTH",
            "3,true,FIFTH",
            "3,false,FIFTH",
            "2,true,MISS",
            "2,false,MISS",
            "1,true,MISS",
            "1,false,MISS",
            "0,true,MISS",
            "0,false,MISS"
    })
    void Rank_Of_ReturnsCorrectRank(int matchNumberCount, Boolean matchBonus, Rank expectedRank) {
        Rank rank = Rank.of(matchNumberCount, matchBonus);

        assertThat(rank).isEqualTo(expectedRank);
    }
}
