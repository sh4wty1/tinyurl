package com.sh4wty1.back_tinyurl.repository;

import com.sh4wty1.back_tinyurl.entities.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    Optional<ShortUrl> findByShortCode(String shortCode);
}
