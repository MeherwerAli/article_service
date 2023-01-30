package org.backend.article_service.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "article", uniqueConstraints =
@UniqueConstraint(columnNames = "header"))
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private long articleId;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "text", nullable = false)
    private String content;

    @Column(name = "author/s", nullable = false)
    private String authors;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "publish_date", nullable = false)
    private Date publishDate;

    @Column(name = "last_modified", nullable = false)
    private Date lastModified;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @PrePersist
    void preInsert(){
        if(null == this.isDeleted){
            this.isDeleted = Boolean.FALSE;
        }
        if(null == this.publishDate){
            this.publishDate = new Date();
        }
        this.lastModified = new Date();
    }


}
