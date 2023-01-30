package org.backend.article_service.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {

    private long articleId;
    private String title;
    private String header;
    private String shortDescription;
    private String content;
    private List<String> author;
    private List<String> keywords;
    private Date publishDate;
    private Boolean isDeleted = Boolean.FALSE;

}
