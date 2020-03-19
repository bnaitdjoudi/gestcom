package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detail_bl database table.
 * 
 */
@Entity
@Table(name="detail_bl")
@NamedQuery(name="DetailBl.findAll", query="SELECT d FROM DetailBl d")
public class DetailBl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETAIL_BL_ID_GENERATOR", sequenceName="DETAIL_BL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETAIL_BL_ID_GENERATOR")
	private Integer id;

	private BigDecimal duree;

	private BigDecimal qte;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	//bi-directional many-to-one association to Bl
	@ManyToOne
	@JoinColumn(name="blid")
	private Bl bl;

	public DetailBl() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getDuree() {
		return this.duree;
	}

	public void setDuree(BigDecimal duree) {
		this.duree = duree;
	}

	public BigDecimal getQte() {
		return this.qte;
	}

	public void setQte(BigDecimal qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Bl getBl() {
		return this.bl;
	}

	public void setBl(Bl bl) {
		this.bl = bl;
	}

}