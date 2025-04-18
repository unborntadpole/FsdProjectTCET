package com.Magazine.MagazinesNewsletters.service;

import com.Magazine.MagazinesNewsletters.entity.Newsletter;
import com.Magazine.MagazinesNewsletters.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsletterService {

    @Autowired
    private NewsletterRepository newsletterRepository;

    public List<Newsletter> getAllNewsletters() {
        return newsletterRepository.findAll();
    }

    public Optional<Newsletter> getNewsletterById(Long id) {
        return newsletterRepository.findById(id);
    }

    public Newsletter createNewsletter(Newsletter newsletter) {
        return newsletterRepository.save(newsletter);
    }

    public void deleteNewsletter(Long id) {
        newsletterRepository.deleteById(id);
    }

    public Newsletter updateNewsletter(Long id, Newsletter updated) {
        return newsletterRepository.findById(id).map(newsletter -> {
            newsletter.setTitle(updated.getTitle());
            newsletter.setContent(updated.getContent());
            newsletter.setAuthor(updated.getAuthor());
            newsletter.setPublishedAt(updated.getPublishedAt());
            return newsletterRepository.save(newsletter);
        }).orElseThrow(() -> new RuntimeException("Newsletter not found"));
    }
}

