package dz.facturation.service;


import dz.facturation.model.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * service for Article
 */
public interface ArticleService {

    /**
     * get Article by pageable
     * @param pageable object content all information of paging
     * @return list of article
     */
    Page<Article> getArticleByPageable(Pageable pageable);

    Article create(Article article);
}
