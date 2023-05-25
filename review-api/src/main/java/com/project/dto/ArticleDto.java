package com.project.dto;

import com.project.constants.ArticleCategory;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ArticleDto {
    private Long id;

    private String articleTitle;

    private String articleContent;

    private ArticleCategory articleCategory;

    private Long userId;
}
