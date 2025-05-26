package com.dijitalkart.repository;

import com.dijitalkart.model.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLink, Long> {
    List<SocialLink> findByUserId(Long userId);
    void deleteByUserIdAndPlatform(Long userId, String platform);
} 