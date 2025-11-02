package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void createLottoService() {
        lottoService = new LottoService(new LottoGenerator());
    }

    @ParameterizedTest
    @DisplayName("구매 금액을 받아 구매할 로또 개수를 계산한다.")
    @CsvSource(value = {"8000,8", "1000,1", "100000,100"})
    void LottoService_PurchaseLottos_ReturnLottos(int inputAmount, int expected) {
        Amount amount = new Amount(inputAmount);

        Lottos myLottos = lottoService.purchaseLottos(amount);

        assertThat(myLottos.getLottoCount()).isEqualTo(expected);
    }
}
