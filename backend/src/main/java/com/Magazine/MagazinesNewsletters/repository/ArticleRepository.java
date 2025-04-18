package com.Magazine.MagazinesNewsletters.repository;

import com.Magazine.MagazinesNewsletters.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // Additional query methods if needed
}

