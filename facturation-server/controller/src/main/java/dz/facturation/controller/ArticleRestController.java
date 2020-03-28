package dz.facturation.controller;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.Article;
import dz.facturation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Article Rest controller
 */
@RestController
@RequestMapping("/articles")
public class ArticleRestController {

    @Autowired
    ArticleService articleService;

    /**
     * create new Article
     *
     * @param article object Article
     * @return article créé
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Article> create(@RequestBody Article article) {
        return ResponseEntity.ok(articleService.create(article));
    }

    /**
     * find all article by pagination
     *
     * @param critereQuery object of pagination
     * @return page object contents all informations about paging and list of article
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QueryResult<Article>> getAllByPageable(CritereQuery critereQuery) {
        return ResponseEntity.ok(articleService.getArticleByPageable(critereQuery));
    }

    /**
     * update article
     *
     * @param idArticle id article
     * @param values    object of update
     * @return page object contents all informations about paging and list of article
     */
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@PathVariable("id") Long idArticle, @RequestBody Map<String, Object> values) {
        values.put("id", idArticle);
        if (!articleService.updateArticle(idArticle, values)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * @param idArticle ident of Article
     * @return
     */
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long idArticle) {
        articleService.deleteArticleById(idArticle);
        return ResponseEntity.accepted().build();
    }

    /**
     * find all article by pagination
     *
     * @param critereQuery object of pagination
     * @return page object contents all informations about paging and list of article
     */
    @PostMapping(path = "search",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QueryResult<Article>> search(@RequestBody  CritereQuery critereQuery) {

        return ResponseEntity.ok(articleService.getArticleByPageable(critereQuery));
    }

}
