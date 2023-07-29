package com.project.controller;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import com.project.dto.ArticleDto;
import com.project.dto.PagedArticleDto;
import com.project.service.ArticleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        ArticleDto createdArticleDto = articleService.createArticle(articleDto);
        return new ResponseEntity<>(createdArticleDto, HttpStatus.CREATED);
    }

    @GetMapping("/categories/{articleCategory}/{pageNo}")
    public ResponseEntity<PagedArticleDto> listArticlesByCategory(@PathVariable("articleCategory") ArticleCategory articleCategory,
                                                                  @PathVariable("pageNo") Integer pageNo) {

        PagedArticleDto pagedArticleDto = articleService.listArticlesByCategory(articleCategory, pageNo);
        return new ResponseEntity<>(pagedArticleDto, HttpStatus.OK);
    }
}
