package com.sh4wty1.back_tinyurl.controller;

import com.sh4wty1.back_tinyurl.dto.CreateShortUrlRequest;
import com.sh4wty1.back_tinyurl.dto.UrlStatsResponse;
import com.sh4wty1.back_tinyurl.entities.ShortUrl;
import com.sh4wty1.back_tinyurl.service.ShortUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/")
public class ShortUrlController {

    private final ShortUrlService service;

    public ShortUrlController(ShortUrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public String createShortUrl(@RequestBody CreateShortUrlRequest request) {
        return "https://localhost:8080/" + service.createShortUrl(request.getUrl());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        ShortUrl shortUrl = service.getOriginalUrl(code);

        URI uri = URI.create(shortUrl.getOriginalUrl());

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(uri)
                .build();
    }

    @GetMapping("/stats/{code}")
    public UrlStatsResponse getStats(@PathVariable String code) {
        ShortUrl shortUrl = service.getStats(code);

        return new UrlStatsResponse(
                shortUrl.getOriginalUrl(),
                shortUrl.getClickCount(),
                shortUrl.getCreatedAt()
        );
    }

}
