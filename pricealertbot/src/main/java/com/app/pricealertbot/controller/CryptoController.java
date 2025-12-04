package com.app.pricealertbot.controller;

import com.app.pricealertbot.dto.BinanceTicker;
import com.app.pricealertbot.service.BinanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    private final BinanceService binanceService;

    public CryptoController(BinanceService binanceService) {
        this.binanceService = binanceService;
    }

    @GetMapping("/btc")
    public BinanceTicker getBtcPrice() {
        return binanceService.getBitcoinPrice();
    }
}
