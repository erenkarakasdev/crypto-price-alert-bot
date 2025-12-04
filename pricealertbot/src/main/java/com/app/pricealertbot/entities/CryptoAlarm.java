package com.app.pricealertbot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "alarms")
public class CryptoAlarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private Double targetPrice;

    @Enumerated(EnumType.STRING)
    private Direction direction;

    private Long userId;

    private boolean isEnabled = true;
}
