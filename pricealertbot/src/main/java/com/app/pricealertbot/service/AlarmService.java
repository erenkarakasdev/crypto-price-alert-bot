package com.app.pricealertbot.service;

import com.app.pricealertbot.dto.BinanceTicker;
import com.app.pricealertbot.entities.CryptoAlarm;
import com.app.pricealertbot.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AlarmService {
    private final RestClient restClient;

    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private  BinanceService binanceService;

    public AlarmService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.binance.com")
                .build();
    }
}
