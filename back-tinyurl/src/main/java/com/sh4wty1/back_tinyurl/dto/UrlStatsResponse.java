package com.sh4wty1.back_tinyurl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UrlStatsResponse {

    private String url;
    private int clicks;
    private LocalDateTime createdAt;
}
