package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseLotto;
import lotto.service.LottoService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService,
                           InputView inputView,
                           OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        PurchaseLotto purchaseLotto = retryUntilSuccess(() -> {
            int purchaseAmount = Validator.validatePurchaseAmount(inputView.readPurchaseAmount());
            return lottoService.createLottos(purchaseAmount);
        });

        outputView.printPurchaseCount(purchaseLotto.getLottoSize());
        outputView.printPurchaseLotto(purchaseLotto.getFormattedLottos());

        Lotto winningNumber = retryUntilSuccess(() -> {
            List<Integer> nums = Validator.validateWinningNumber(inputView.readWinningNumbers());
            return lottoService.createWinningNumber(nums);
        });

    }

    private <T> T retryUntilSuccess(java.util.function.Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
