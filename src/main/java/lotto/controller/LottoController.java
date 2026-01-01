package lotto.controller;

import lotto.domain.PurchaseLotto;
import lotto.service.LottoService;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            int purchaseAmount = Validator.validatePurchaseAmount(inputView.readPurchaseAmount());
            PurchaseLotto purchaseLotto = lottoService.createLottos(purchaseAmount);
            outputView.printPurchaseCount(purchaseLotto.getLottoSize());
            outputView.printPurchaseLotto(purchaseLotto.getFormattedLottos());
        } catch (RuntimeException e) {
            outputView.printError(e);
        }
    }
}
