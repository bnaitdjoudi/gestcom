package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the prix_article database table.
 * 
 */
@Entity
@Table(name="prix_article")
@NamedQuery(name="PrixArticle.findAll", query="SELECT p FROM PrixArticle p")
public class PrixArticle extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRIX_ARTICLE_ID_GENERATOR", sequenceName="PRIX_ARTICLE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIX_ARTICLE_ID_GENERATOR")
	private Long id;

	private Boolean active;

	@Column(name="date_prix")
	private Timestamp datePrix;

	private BigDecimal prix;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	public PrixArticle() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getDatePrix() {
		return this.datePrix;
	}

	public void setDatePrix(Timestamp datePrix) {
		this.datePrix = datePrix;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}