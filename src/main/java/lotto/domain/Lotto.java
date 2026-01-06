package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        List<Integer> comparison = numbers.stream()
                .distinct()
                .toList();
        if (numbers.size() != comparison.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_DUPLICATED.getMessage());
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_IS_INCORRECT.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
