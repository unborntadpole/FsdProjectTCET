//package com.Magazine.MagazinesNewsletters.controller;
//
//import com.Magazine.MagazinesNewsletters.entity.Article;
//import com.Magazine.MagazinesNewsletters.service.ArticleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/articles")
//@CrossOrigin(origins = "*") // allow Angular to access this
//public class ArticleController {
//
//    @Autowired
//    private ArticleService articleService;
//
//    @GetMapping
//    public List<Article> getAllArticles() {
//        return articleService.getAllArticles();
//    }
//
//    @GetMapping("/{id}")
//    public Article getArticleById(@PathVariable Long id) {
//        return articleService.getArticleById(id).orElse(null);
//    }
//
//    @PostMapping
//    public Article createArticle(@RequestBody Article article) {
//        return articleService.createArticle(article);
//    }
//
//    @PutMapping("/{id}")
//    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
//        return articleService.updateArticle(id, article);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteArticle(@PathVariable Long id) {
//        articleService.deleteArticle(id);
//    }
//}
//

package com.Magazine.MagazinesNewsletters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.Magazine.MagazinesNewsletters.entity.Article;
import com.Magazine.MagazinesNewsletters.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*") // allow Angular to access this
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        logger.info("Fetching all articles");
        List<Article> articles = articleService.getAllArticles();
        logger.info("Successfully fetched {} articles", articles.size());
        return articles;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        logger.info("Fetching article with ID {}", id);
        Article article = articleService.getArticleById(id).orElse(null);
        if (article != null) {
            logger.info("Successfully fetched article with ID {}", id);
        } else {
            logger.warn("Article with ID {} not found", id);
        }
        return article;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        logger.info("Creating a new article with title: {}", article.getTitle());
        article.setId(null);
        Article createdArticle = articleService.createArticle(article);
        logger.info("Successfully created article with ID {}", createdArticle.getId());
        return createdArticle;
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        logger.info("Updating article with ID {}", id);
        Article updatedArticle = articleService.updateArticle(id, article);
        if (updatedArticle != null) {
            logger.info("Successfully updated article with ID {}", id);
        } else {
            logger.warn("Article with ID {} not found for update", id);
        }
        return updatedArticle;
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        logger.info("Deleting article with ID {}", id);
        articleService.deleteArticle(id);
        logger.info("Successfully deleted article with ID {}", id);
    }
}
