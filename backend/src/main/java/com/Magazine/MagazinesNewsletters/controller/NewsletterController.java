package com.Magazine.MagazinesNewsletters.controller;

import com.Magazine.MagazinesNewsletters.entity.Newsletter;
import com.Magazine.MagazinesNewsletters.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newsletters")
@CrossOrigin(origins = "*") // Allow access from frontend/postman
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping
    public List<Newsletter> getAll() {
        return newsletterService.getAllNewsletters();
    }

    @GetMapping("/{id}")
    public Newsletter getById(@PathVariable Long id) {
        return newsletterService.getNewsletterById(id)
                .orElseThrow(() -> new RuntimeException("Newsletter not found"));
    }

    @PostMapping
    public Newsletter create(@RequestBody Newsletter newsletter) {
        return newsletterService.createNewsletter(newsletter);
    }

    @PutMapping("/{id}")
    public Newsletter update(@PathVariable Long id, @RequestBody Newsletter updated) {
        return newsletterService.updateNewsletter(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        newsletterService.deleteNewsletter(id);
    }
}
