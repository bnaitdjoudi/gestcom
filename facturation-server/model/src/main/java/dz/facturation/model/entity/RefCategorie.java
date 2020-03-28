package dz.facturation.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ref_categorie database table.
 * 
 */
@Entity
@Table(name="ref_categorie")
@NamedQuery(name="RefCategorie.findAll", query="SELECT r FROM RefCategorie r")
public class RefCategorie extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REF_CATEGORIE_ID_GENERATOR", sequenceName="REF_CATEGORIE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_CATEGORIE_ID_GENERATOR")
	private Long id;

	private String libelle;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="refCategorie")
	private List<Article> articles;

	public RefCategorie() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setRefCategorie(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setRefCategorie(null);

		return article;
	}

}