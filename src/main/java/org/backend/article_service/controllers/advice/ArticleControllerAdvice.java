package org.backend.article_service.controllers.advice;

import org.backend.article_service.exception.NoRecordsFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ArticleControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ArticleControllerAdvice.class);

    @ExceptionHandler(NoRecordsFoundException.class)
    public ResponseEntity<String> handleNoRecordsFoundException(NoRecordsFoundException ex) {
        logger.error("No records found exception: %s", ex.getMessage());
        return ResponseEntity.notFound().build();
    }

}
