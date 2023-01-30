package org.backend.article_service.mapper;

import org.backend.article_service.builder.ArticleBuilder;
import org.backend.article_service.dto.Article;
import org.backend.article_service.entity.ArticleEntity;

import java.util.Arrays;

public class ArticleMapper {

    private ArticleMapper(){

    }

    public static ArticleBuilder mapToArticleBuilder(ArticleEntity articleEntity){

        return ArticleBuilder.builder()
                .articleId(articleEntity.getArticleId())
                .articleTitle(articleEntity.getHeader())
                .articleSubTitle(articleEntity.getShortDescription())
                .articleContent(articleEntity.getContent())
                .articleAuthors(Arrays.asList(articleEntity.getAuthors().split(",")))
                .articleKeywords(Arrays.asList(articleEntity.getKeywords().split(",")))
                .articlePublishDate(articleEntity.getPublishDate())
                .build();

    }

    public static ArticleEntity mapToArticleEntity(Article article){

        return ArticleEntity.builder()
                .articleId(article.getArticleId())
                .header(article.getTitle())
                .shortDescription(article.getShortDescription())
                .content(article.getContent())
                .authors(String.join(",", article.getAuthor()))
                .keywords(String.join(",", article.getKeywords()))
                .publishDate(article.getPublishDate())
                .isDeleted(article.getIsDeleted())
                .build();

    }

}
