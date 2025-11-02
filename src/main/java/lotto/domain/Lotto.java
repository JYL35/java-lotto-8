package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private static final int COUNT_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);

        List<LottoNumber> defensiveCopyNumbers = new ArrayList<>(numbers);

        Collections.sort(defensiveCopyNumbers);

        this.numbers = defensiveCopyNumbers;
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(String.format(ErrorMessage
                    .LOTTO_NUMBER_COUNT_INCORRECT
                    .getMessage(), COUNT_LOTTO_NUMBERS));
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        List<LottoNumber> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE
                    .getMessage());
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers
                .contains(lottoNumber);
    }

    public int matchCountOtherLottoNumber(Lotto otherLotto) {
        return (int) numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
