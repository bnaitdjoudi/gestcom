package dz.facturation.service;


import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * service for Article
 */
public interface ArticleService {

    /**
     * get Article by pageable
     *
     * @param critereQuery object content all information of paging
     * @return list of article
     */
    QueryResult<Article> getArticleByPageable(CritereQuery critereQuery);

    /**
     * create new article
     *
     * @param article object
     * @return created article
     */
    Article create(Article article);

    /**
     * update article
     *
     * @param values    to update in article
     * @param idArticle id of Article
     * @return boolean true if it is ok
     */
    boolean updateArticle(Long idArticle, Map<String, Object> values);

    /**
     * delete article
     * @param idArticle
     */
    void deleteArticleById(Long idArticle);
}
