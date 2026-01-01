package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {

    }
}
