package com.project.service.impl;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import com.project.dto.ArticleDto;
import com.project.dto.PagedArticleDto;
import com.project.entities.Article;
import com.project.entities.DateTimeLogger;
import com.project.entities.User;
import com.project.repository.ArticleRepository;
import com.project.repository.UserRepository;
import com.project.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return convertToDto(article);
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
    public PagedArticleDto listArticlesByCategory(ArticleCategory articleCategory, Integer pageNo) {
        Sort sort = Sort.by("last_updated_tp");
        Pageable pageable = PageRequest.of(pageNo, 10, sort); //TODO : To read page size from configuration
        Page<Article> articlePages = articleRepository.findByArticleCategory(articleCategory, ArticleStatus.DRAFT, pageable);
        List<Article> articles = articlePages.getContent();
        int totalPage = articlePages.getTotalPages();
        long totalElements = articlePages.getTotalElements();
        int numberOfElements = articlePages.getNumberOfElements();
        int size = articlePages.getSize();
        boolean isLast = articlePages.isLast();
        boolean isFirst = articlePages.isFirst();

        List<ArticleDto> articleDtos = articles
                .stream()
                .map(this::convertToDto).toList();

        return PagedArticleDto
        .builder()
        .articleDtos(articleDtos)
        .totalPage(totalPage)
        .totalElements(totalElements)
        .numberOfElements(numberOfElements)
        .size(size)
        .isLast(isLast)
        .isFirst(isFirst)
        .build();

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

    private ArticleDto convertToDto(Article article) {
        return ArticleDto
                .builder()
                .id(article.getId())
                .articleTitle(article.getArticleTitle())
                .articleContent(article.getArticleContent())
                .articleCategory(article.getArticleCategory())
                .userId(article.getUser().getId())
                .build();

    }
}
