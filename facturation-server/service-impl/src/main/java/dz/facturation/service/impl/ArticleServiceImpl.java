package dz.facturation.service.impl;

import dz.facturation.model.entity.Article;
import dz.facturation.repository.ArticleDao;
import dz.facturation.service.ArticleService;
import dz.facturation.tools.EntityTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * Article Service implementation
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public Page<Article> getArticleByPageable(Pageable pageable) {
        return articleDao.findAll(pageable);
    }

    @Override
    public Article create(Article article) {
        return articleDao.save(article);
    }

    @Override
    public boolean updateArticle(Integer idArticle, Map<String, Object> values) {
        Optional<Article> articleOptional = articleDao.findById(idArticle);
        if (articleOptional.isEmpty()) {
            return false;
        } else {
            Article article = articleOptional.get();
            article = EntityTools.updateObjectFromMap(values, article);
            articleDao.save(article);
        }
        return true;
    }

    @Override
    public void deleteArticleById(Integer idArticle) {
        
    }
}
