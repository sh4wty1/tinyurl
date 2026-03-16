package com.sh4wty1.back_tinyurl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortCode;
    private String originalUrl;
    private int clickCount;
    private LocalDateTime createdAt;

    public ShortUrl() {}

    public ShortUrl(String originalUrl) {
        this.clickCount = 0;
        this.createdAt = LocalDateTime.now();
        this.originalUrl = originalUrl;
    }
}
