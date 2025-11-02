package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.view.ViewManager;

public class LottoController {
    private final ViewManager viewManager;
    private final LottoService lottoService;

    public LottoController(ViewManager viewManager, LottoService lottoService) {
        this.viewManager = viewManager;
        this.lottoService = lottoService;
    }

    public void startGame() {
        Amount amount = viewManager.getValidAmount();
        Lottos userLottos = lottoService.purchaseLottos(amount);

        Lotto winningLotto = viewManager.getValidWinningLotto();
        WinningLotto winningLottoSet = viewManager.getValidBonusNumber(winningLotto);

        GameResult gameResult = userLottos.calculateWinningStatistics(winningLottoSet);
        double userProfitRate = amount.getProfitRate(gameResult.getTotalPrize());
    }
}
