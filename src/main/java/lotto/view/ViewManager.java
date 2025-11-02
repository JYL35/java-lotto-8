package lotto.view;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.util.InputParser;

public class ViewManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public ViewManager(InputView inputView,
                       OutputView outputView,
                       InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public Amount getValidAmount() {
        try {
            return processAmountInput();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getValidAmount();
        }
    }

    public Lotto getValidWinningLotto() {
        try {
            return processWinningLottoInput();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getValidWinningLotto();
        }
    }

    public WinningLotto getValidBonusNumber(Lotto winningLotto) {
        try {
            return processBonusNumberInput(winningLotto);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getValidBonusNumber(winningLotto);
        }
    }

    public void printPurchaseResult(Amount amount, Lottos userLottos) {
        outputView.printPurchaseCount(amount.getLottoPurchaseCount());
        outputView.printPurchaseLottos(userLottos.getFormattedLottos());
    }

    public void printStatistics(GameResult gameResult, double profitRate) {
        outputView.printStatisticsHeader();
        outputView.printStatistics(gameResult);
        outputView.printProfitRate(profitRate);
    }

    private Amount processAmountInput() {
        String inputAmount = inputView.readPurchaseAmount();
        int parsedAmount = inputParser.parseAmount(inputAmount);
        return new Amount(parsedAmount);
    }

    private Lotto processWinningLottoInput() {
        String inputWinningNumbers = inputView.readWinningNumbers();
        List<Integer> parsedWinningNumbers = inputParser.parseWinningNumbers(inputWinningNumbers);
        return new Lotto(parsedWinningNumbers.stream()
                .map(LottoNumber::new)
                .toList());
    }

    private WinningLotto processBonusNumberInput(Lotto winningLotto) {
        String inputBonusNumber = inputView.readBonusNumber();
        int bonusNumber = inputParser.parseBonusNumber(inputBonusNumber);
        return new WinningLotto(winningLotto, new LottoNumber(bonusNumber));
    }
}
