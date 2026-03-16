package com.sh4wty1.back_tinyurl.service;

import com.sh4wty1.back_tinyurl.entities.ShortUrl;
import com.sh4wty1.back_tinyurl.repository.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShortUrlService {
     private final ShortUrlRepository repository;

     public ShortUrlService(ShortUrlRepository repository) {
         this.repository = repository;
     }

    private String generateShortCode() {
         return UUID.randomUUID().toString().substring(0,6);
    }

     public String createShortUrl(String url) {
        String shortCode = generateShortCode();
        ShortUrl shortUrl = new ShortUrl(url);
        shortUrl.setShortCode(shortCode);

        repository.save(shortUrl);

        return shortCode;
     }

    public ShortUrl getOriginalUrl(String code) {

        ShortUrl shortUrl = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        shortUrl.setClickCount(shortUrl.getClickCount() + 1);

        repository.save(shortUrl);

        return shortUrl;
    }

    public ShortUrl getStats(String code) {
        return repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }
}
