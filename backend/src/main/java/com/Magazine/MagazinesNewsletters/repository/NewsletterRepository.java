package com.Magazine.MagazinesNewsletters.repository;


import com.Magazine.MagazinesNewsletters.entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsletterRepository extends JpaRepository<Newsletter, Long> {
}
