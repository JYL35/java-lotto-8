package lotto.service.domain;

import java.util.Objects;
import lotto.constant.ErrorMessage;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MAXIMUM_RANGE = 45;
    private static final int MINIMUM_RANGE = 1;

    private final int lottoNumber;

    public LottoNumber(int number) {
        validate(number);
        this.lottoNumber = number;
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (MINIMUM_RANGE > number || MAXIMUM_RANGE < number) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(lottoNumber, o.lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }
}
