package lotto.controller;

import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            int purchaseAmount = readPurchaseAmount();
        } catch (RuntimeException e) {
            outputView.printError(e);
        }
    }

    private int readPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = inputView.inputPurchaseAmount();
                return Parser.parsePurchaseAmount(inputPurchaseAmount);
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }
}
