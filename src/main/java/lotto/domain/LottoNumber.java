package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int lottoNum;

    public LottoNumber(int lottoNum) {
        validateRange(lottoNum);
        this.lottoNum = lottoNum;
    }

    private void validateRange(int lottoNum) {
        if (lottoNum < MIN_NUMBER || lottoNum > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format(
                    "[ERROR] 번호는 %,d 이상, %,d 이하여야 됩니다. 다시 입력해주세요.",
                    MIN_NUMBER, MAX_NUMBER
            ));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LottoNumber that)) return false;
        return lottoNum == that.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNum);
    }
}