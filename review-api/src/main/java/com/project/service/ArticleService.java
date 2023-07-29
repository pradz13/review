package com.project.service;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import com.project.dto.ArticleDto;
import com.project.dto.PagedArticleDto;

import java.util.List;

public interface ArticleService {
    public ArticleDto createArticle(ArticleDto articleDto);

    public ArticleDto updateArticle(ArticleDto articleDto);

    public ArticleDto submitArticle(Long articleId);

    public ArticleDto reviewArticle(Long articleId);

    public List<ArticleDto> listArticlesForUser(Long userId);

    public PagedArticleDto listArticlesByCategory(ArticleCategory articleCategory, Integer pageNo);
}
