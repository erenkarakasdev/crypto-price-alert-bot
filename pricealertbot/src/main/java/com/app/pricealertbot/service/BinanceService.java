package com.app.pricealertbot.service;

import com.app.pricealertbot.dto.BinanceTicker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BinanceService {


    private final RestClient restClient;

    public BinanceService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.binance.com")
                .build();
    }

    public BinanceTicker getBitcoinPrice() {
        return restClient.get()
                .uri("/api/v3/ticker/price?symbol=BTCUSDT")
                .retrieve()
                .body(BinanceTicker.class);
    }


}
