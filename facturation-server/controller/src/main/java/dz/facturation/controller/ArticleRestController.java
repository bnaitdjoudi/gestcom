package dz.facturation.controller;

import dz.facturation.model.entity.Article;
import dz.facturation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Article>> getAllByPageable(Pageable pageable){
        return ResponseEntity.ok(articleService.getArticleByPageable(pageable));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Article create(Article article){
        return articleService.create(article);
    }

}
