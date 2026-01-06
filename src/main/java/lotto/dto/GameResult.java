package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public record GameResult(
        Map<Rank, Integer> result,
        double profitRate
) {
}
