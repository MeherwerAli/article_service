package org.backend.article_service.exception;

import org.backend.article_service.util.ArticleServiceConstants;

public class NoRecordsFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private final String code;

    public NoRecordsFoundException() {
        super(ArticleServiceConstants.NO_RECORD_FOUND);
        this.code = "404";
    }

    public String getCode() {
        return code;
    }
}
