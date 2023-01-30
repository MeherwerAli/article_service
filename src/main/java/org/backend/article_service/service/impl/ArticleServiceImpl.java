package org.backend.article_service.service.impl;

import javassist.NotFoundException;
import org.backend.article_service.builder.ArticleBuilder;
import org.backend.article_service.dto.Article;
import org.backend.article_service.entity.ArticleEntity;
import org.backend.article_service.mapper.ArticleMapper;
import org.backend.article_service.repository.ArticleRepository;
import org.backend.article_service.service.ArticleService;
import org.backend.article_service.util.ArticleServiceConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public List<ArticleBuilder> getAllArticles() {
        try {
            List<ArticleBuilder> articlesBuilder =
                    articleRepository.findAllByIsDeletedFalse(Sort.by(Sort.Direction.ASC, ArticleServiceConstants.HEADER)).
                            stream().
                            map(ArticleMapper::mapToArticleBuilder).
                            collect(Collectors.toList());
            return articlesBuilder;
        }catch (Exception ex) {
            logger.error("Error: %s", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ArticleBuilder getArticleById(Integer articleId) {
        try{
            return ArticleMapper.mapToArticleBuilder(articleRepository.findById(articleId).get());
        }
        catch (Exception ex) {
            logger.error("Error: %s", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ArticleBuilder createArticle(Article article) {
        try {
            return ArticleMapper.mapToArticleBuilder(articleRepository.save(ArticleMapper.mapToArticleEntity(article)));
        }catch (Exception ex) {
            logger.error("Error: %s", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ArticleBuilder updateArticle(Article article) {
        try {
            return ArticleMapper.mapToArticleBuilder(articleRepository.save(ArticleMapper.mapToArticleEntity(article)));
        }catch (Exception ex) {
            logger.error("Error: %s", ex.getMessage());
            throw ex;
        }
    }

    @Override
    public String deleteArticleById(Integer articleId) {
        try {
            ArticleEntity articleEntity = articleRepository.findById(articleId).get();
            articleEntity.setIsDeleted(Boolean.TRUE);
            articleRepository.save(articleEntity);
            return ArticleServiceConstants.DELETE_SUCCESSFUL;
        }catch (Exception ex) {
            logger.error("Error: %s", ex.getMessage());
            throw ex;
        }
    }
}
