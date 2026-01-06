package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        try {
            int purchaseAmount = readPurchaseAmount();
            List<Lotto> lottoTickets = lottoService.createLotto(purchaseAmount);
            outputView.printLottoTickets(lottoTickets);
            List<Integer> winningNumbers = readWinningNumbers();
            int bonusNumber = readBonusNumber(winningNumbers);
            WinningLotto winningLotto = lottoService.createWinningLotto(winningNumbers, bonusNumber);
        } catch (RuntimeException e) {
            outputView.printError(e);
        }
    }

    private int readBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = inputView.inputBonusNumber();
                return Parser.parseBonusNumber(inputBonusNumber, winningNumbers);
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
        }
    }

    private List<Integer> readWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputView.inputWinningNumbers();
                return Parser.parseWinningNumbers(inputWinningNumbers);
            } catch (RuntimeException e) {
                outputView.printError(e);
            }
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
