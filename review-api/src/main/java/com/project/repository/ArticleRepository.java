package com.project.repository;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import com.project.entities.Article;
import com.project.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query(value = "SELECT * FROM ARTICLE WHERE article_category = :#{#articleCategory.name()} AND article_status = :#{#articleStatus.name()}", nativeQuery = true)
    Page<Article> findByArticleCategory(@Param("articleCategory") ArticleCategory articleCategory, @Param("articleStatus") ArticleStatus articleStatus, Pageable pageable);
    Page<Article> findByUser(User user, Pageable pageable);
}
