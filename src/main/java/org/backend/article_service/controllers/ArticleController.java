package org.backend.article_service.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.backend.article_service.builder.ArticleBuilder;
import org.backend.article_service.dto.Article;
import org.backend.article_service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping(produces = "application/json")
    @Operation(summary = "Get all articles", description = "Get all articles", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<List<ArticleBuilder>> getAllArticles(){
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping(value = "/{articleId}", produces = "application/json")
    @Operation(summary = "Get article by id", description = "Get article by id", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<ArticleBuilder> getArticleById(@PathVariable("articleId") Integer articleId){
        return new ResponseEntity<>(articleService.getArticleById(articleId), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    @Operation(summary = "Create article", description = "Create article", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
    ResponseEntity<ArticleBuilder> createArticle(Article article){
        return new ResponseEntity<>(articleService.createArticle(article), HttpStatus.CREATED);
    }

    @PutMapping(produces = "application/json")
    @Operation(summary = "Update article", description = "Update article", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<ArticleBuilder> updateArticle(Article article){
        return new ResponseEntity<>(articleService.updateArticle(article), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{articleId}", produces = "application/json")
    @Operation(summary = "Delete article by id", description = "Delete article by id", tags = {"article"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    ResponseEntity<String> deleteArticleById(Integer articleId){
        return new ResponseEntity<>(articleService.deleteArticleById(articleId), HttpStatus.OK);
    }


}
