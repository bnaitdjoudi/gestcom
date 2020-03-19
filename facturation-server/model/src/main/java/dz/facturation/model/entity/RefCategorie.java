package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ref_categorie database table.
 * 
 */
@Entity
@Table(name="ref_categorie")
@NamedQuery(name="RefCategorie.findAll", query="SELECT r FROM RefCategorie r")
public class RefCategorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idcateg;

	private String libelle;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="refCategorie")
	private List<Article> articles;

	public RefCategorie() {
	}

	public String getIdcateg() {
		return this.idcateg;
	}

	public void setIdcateg(String idcateg) {
		this.idcateg = idcateg;
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