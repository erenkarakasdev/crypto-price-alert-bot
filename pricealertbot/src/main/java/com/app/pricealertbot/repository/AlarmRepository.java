package com.app.pricealertbot.repository;

import com.app.pricealertbot.entities.CryptoAlarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<CryptoAlarm, Long> {

    List<CryptoAlarm> findByIsEnabledTrue(String symbol);
}
