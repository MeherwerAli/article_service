package org.backend.article_service.util;

public final class ArticleServiceConstants {

    private ArticleServiceConstants() {
        // restrict instantiation
    }


    public static final String CREATE_SUCCESSFUL = "Article created successfully !!!";
    public static final String UPDATE_SUCCESSFUL = "Article update successfully !!!";
    public static final String DELETE_SUCCESSFUL = "Article update successfully !!!";
    public static final String HEADER_ALREADY_TAKEN = "Header already taken!! Kindly use another header.";

    public static final String HEADER = "header";

    public static final String ERROR_EMPTY_HEADER = "Header cannot be empty!";
    public static final String ERROR_EMPTY_AUTHOR_NAME = "Author Name cannot be empty!!";
    public static final String ERROR_EMPTY_CONTENT = "Content cannot be empty for the article!!!";
    public static final String NOT_FOUND = "Article not found with id: %s";
    public static final String NO_RECORD_FOUND = "No records founds";

    public static final String ERROR_STRING = "Error:";

}
