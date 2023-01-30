package org.backend.article_service.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@ToString
public class ArticleBuilder {

    private long articleId;
    private String articleTitle;
    private String articleSubTitle;
    private String articleContent;
    private List<String> articleAuthors;
    private List<String> articleKeywords;
    private Date articlePublishDate;

    private ArticleBuilder(){

    }

}
