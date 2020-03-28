package dz.facturation.service.impl;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.entity.Article;
import dz.facturation.repository.ArticleDao;
import dz.facturation.service.ArticleService;
import dz.facturation.tools.EntityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Article Service implementation
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Transactional(readOnly = true)
    @Override
    public QueryResult<Article> getArticleByPageable(CritereQuery critereQuery) {
        critereQuery.setDataProperties(List.of("id","nomarticle","minqte","refCategorie"));
        return articleDao.processCriteriaQuery(critereQuery);
    }
    @Transactional
    @Override
    public Article create(Article article) {
        return articleDao.create(article);
    }

    @Override
    @Transactional
    public boolean updateArticle(Long idArticle, Map<String, Object> values) {
        Optional<Article> articleOptional = articleDao.findById(idArticle);
        if (articleOptional.isEmpty()) {
            return false;
        } else {
            Article article = articleOptional.get();
            article = EntityTools.updateObjectFromMap(values, article);
            articleDao.update(article);
        }
        return true;
    }

    @Override
    public void deleteArticleById(Long idArticle) {
        Optional<Article> articleOptional = articleDao.findById(idArticle);
        if(!articleOptional.isEmpty()){
            articleDao.deleteBy(articleOptional.get().getId());
        }

    }
}
