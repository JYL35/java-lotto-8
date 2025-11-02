package lotto.config;

import lotto.controller.LottoController;
import lotto.service.LottoGenerator;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.ViewManager;

public class AppConfig {
    public LottoController lottoController() {
        ViewManager viewManager = new ViewManager(new InputView(),
                new OutputView(),
                new InputParser());
        LottoService lottoService = new LottoService(new LottoGenerator());

        return new LottoController(viewManager, lottoService);
    }
}
