package lotto.service.domain;

import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        validateCount(numbers);
        validateDuplication(numbers);
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_COUNT_OVER.getMessage());
        }
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        List<LottoNumber> tempNumbers = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != tempNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }
}
