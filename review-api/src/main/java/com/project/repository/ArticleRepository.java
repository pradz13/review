package com.project.repository;

import com.project.constants.ArticleCategory;
import com.project.entities.Article;
import com.project.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Page<Article> findByArticleCategory(ArticleCategory articleCategory, Pageable pageable);
    Page<Article> findByUser(User user, Pageable pageable);
}
