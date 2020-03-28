package dz.facturation.repository.impl;

import dz.facturation.model.entity.Article;
import dz.facturation.repository.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * repository implementation Article
 */
@Repository
public class ArticleDaoImpl extends GenericDao<Article,Long> implements dz.facturation.repository.ArticleDao {

    public ArticleDaoImpl() {
        super(Article.class);
    }
}
