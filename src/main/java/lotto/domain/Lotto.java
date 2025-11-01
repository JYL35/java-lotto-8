package lotto.domain;

import java.util.List;

public class Lotto {
    private static final int COUNT_LOTTO_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != COUNT_LOTTO_NUMBERS) {
            throw new IllegalArgumentException(String.format(
                    "[ERROR] 로또 번호는 %d개여야 합니다.",
                    COUNT_LOTTO_NUMBERS));
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        List<LottoNumber> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복됩니다.");
        }
    }
}
