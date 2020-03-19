package dz.facturation.repository;

import dz.facturation.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Dao for Article
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {
}
