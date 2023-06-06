package com.project.service.impl;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import com.project.dto.ArticleDto;
import com.project.entities.Article;
import com.project.entities.DateTimeLogger;
import com.project.entities.User;
import com.project.repository.ArticleRepository;
import com.project.repository.UserRepository;
import com.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        Long userId = articleDto.getUserId();
        User user = userRepository.findById(userId).orElse(null);
        if(user == null)
            throw new UsernameNotFoundException("User not found with Id : " + userId);

        Article article = convertToEntity(articleDto, user);
        article  = articleRepository.save(article);
        user.getArticles().add(article);
        userRepository.save(user);
        return convertToDto(article, userId);
    }

    @Override
    public ArticleDto updateArticle(ArticleDto articleDto) {
        return null;
    }

    @Override
    public ArticleDto submitArticle(Long articleId) {
        return null;
    }

    @Override
    public ArticleDto reviewArticle(Long articleId) {
        return null;
    }

    @Override
    public List<ArticleDto> listArticlesForUser(Long userId) {
        return null;
    }

    @Override
    public List<ArticleDto> listArticlesByCategory(ArticleCategory articleCategory, ArticleStatus articleStatus) {
        return null;
    }

    private Article convertToEntity(ArticleDto articleDto, User user) {
        return Article
                .builder()
                .articleTitle(articleDto.getArticleTitle())
                .articleContent(articleDto.getArticleContent())
                .articleCategory(articleDto.getArticleCategory())
                .articleStatus(ArticleStatus.DRAFT)
                .user(user)
                .dateTimeLogger(DateTimeLogger.builder()
                        .createdTp(LocalDateTime.now())
                        .lastUpdatedTp(LocalDateTime.now())
                        .build())
                .build();

    }

    private ArticleDto convertToDto(Article article, Long userId) {
        return ArticleDto
                .builder()
                .id(article.getId())
                .articleTitle(article.getArticleTitle())
                .articleContent(article.getArticleContent())
                .articleCategory(article.getArticleCategory())
                .userId(userId)
                .build();

    }
}
