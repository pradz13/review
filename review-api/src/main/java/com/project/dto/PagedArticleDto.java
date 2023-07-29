package com.project.dto;

import com.project.entities.Article;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagedArticleDto {
    private List<ArticleDto> articleDtos;
    private int totalPage;
    private long totalElements;
    private int numberOfElements;
    private int size;
    private boolean isLast;
    private boolean isFirst;
}
