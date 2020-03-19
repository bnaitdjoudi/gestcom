package dz.facturation.service.impl;

import dz.facturation.model.entity.Article;
import dz.facturation.repository.ArticleDao;
import dz.facturation.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Article Service implementation
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired ArticleDao articleDao;

    @Override
    public Page<Article> getArticleByPageable(Pageable pageable) {
        return articleDao.findAll(pageable);
    }

    @Override
    public Article create(Article article) {
        return articleDao.save(article);
    }
}
