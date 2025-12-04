package com.app.pricealertbot.service;

import com.app.pricealertbot.dto.BinanceTicker;
import com.app.pricealertbot.entities.CryptoAlarm;
import com.app.pricealertbot.entities.Direction;
import com.app.pricealertbot.repository.AlarmRepository;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.List;

@Component
public class AlarmScheduler {

    private final BinanceService binanceService;
    private final AlarmRepository alarmRepository;

    public AlarmScheduler(BinanceService binanceService, AlarmRepository alarmRepository) {
        this.binanceService = binanceService;
        this.alarmRepository = alarmRepository;
    }

    @Scheduled(fixedRate = 10000)
    public void checkPrices() {
        BinanceTicker ticker = binanceService.getBitcoinPrice();
        Double currentPrice = Double.parseDouble(ticker.price()); // String -> Double çeviri

        System.out.println("--- Kontrol Ediliyor: BTC = " + currentPrice + "$ ---");

        List<CryptoAlarm> alarms = alarmRepository.findByIsEnabledTrue("BTCUSDT");

        for (CryptoAlarm alarm : alarms) {
            boolean triggered = false;

            if (alarm.getDirection() == Direction.DOWN && currentPrice <= alarm.getTargetPrice()) {
                System.out.println("🚨 DÜŞÜŞ ALARMI! Hedef: " + alarm.getTargetPrice());
                triggered = true;
            } else if (alarm.getDirection() == Direction.UP && currentPrice >= alarm.getTargetPrice()) {
                System.out.println("🚀 YÜKSELİŞ ALARMI! Hedef: " + alarm.getTargetPrice());
                triggered = true;
            }

            if (triggered) {
                alarm.setEnabled(false);
                alarmRepository.save(alarm);
            }
        }
    }
}
