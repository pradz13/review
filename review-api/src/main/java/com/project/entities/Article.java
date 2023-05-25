package com.project.entities;

import com.project.constants.ArticleCategory;
import com.project.constants.ArticleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ARTICLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String articleTitle;

    @Lob
    private String articleContent;

    @Enumerated(EnumType.STRING)
    private ArticleCategory articleCategory;

    @Enumerated(EnumType.STRING)
    private ArticleStatus articleStatus;

    @ManyToOne
    private User user;

    @Embedded
    private DateTimeLogger dateTimeLogger;

    private LocalDateTime approvalTp;

}
