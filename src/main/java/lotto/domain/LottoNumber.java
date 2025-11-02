package lotto.domain;

import java.util.Objects;
import lotto.util.ErrorMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validateRange(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validateRange(int lottoNum) {
        if (lottoNum < MIN_NUMBER || lottoNum > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(ErrorMessage
                    .LOTTO_NUMBER_OUT_OF_RANGE
                    .getMessage(), MIN_NUMBER, MAX_NUMBER
            ));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return lottoNum == that.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNum);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNum, o.lottoNum);
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNum);
    }
}
