package org.backend.article_service.service;

import org.backend.article_service.builder.ArticleBuilder;
import org.backend.article_service.dto.Article;

import java.util.List;

public interface ArticleService {

    List<ArticleBuilder> getAllArticles();

    ArticleBuilder getArticleById(Integer articleId);

    ArticleBuilder createArticle(Article article);

    ArticleBuilder updateArticle(Article article);

    String deleteArticleById(Integer articleId);

}
