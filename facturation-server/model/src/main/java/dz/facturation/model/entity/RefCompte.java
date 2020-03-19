package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ref_compte database table.
 * 
 */
@Entity
@Table(name="ref_compte")
@NamedQuery(name="RefCompte.findAll", query="SELECT r FROM RefCompte r")
public class RefCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String scfcod;

	@Temporal(TemporalType.DATE)
	private Date datecmp;

	private String libelle;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="refCompte")
	private List<Article> articles;

	//bi-directional many-to-one association to Tier
	@OneToMany(mappedBy="refCompte")
	private List<Tier> tiers;

	public RefCompte() {
	}

	public String getScfcod() {
		return this.scfcod;
	}

	public void setScfcod(String scfcod) {
		this.scfcod = scfcod;
	}

	public Date getDatecmp() {
		return this.datecmp;
	}

	public void setDatecmp(Date datecmp) {
		this.datecmp = datecmp;
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
		article.setRefCompte(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setRefCompte(null);

		return article;
	}

	public List<Tier> getTiers() {
		return this.tiers;
	}

	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}

	public Tier addTier(Tier tier) {
		getTiers().add(tier);
		tier.setRefCompte(this);

		return tier;
	}

	public Tier removeTier(Tier tier) {
		getTiers().remove(tier);
		tier.setRefCompte(null);

		return tier;
	}

}