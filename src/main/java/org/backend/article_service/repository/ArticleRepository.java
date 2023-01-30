package org.backend.article_service.repository;

import org.backend.article_service.entity.ArticleEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{

    List<ArticleEntity> findAllByIsDeletedFalse(Sort sort);

}
