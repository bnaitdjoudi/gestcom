package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detail_devis database table.
 * 
 */
@Entity
@Table(name="detail_devis")
@NamedQuery(name="DetailDevis.findAll", query="SELECT d FROM DetailDevis d")
public class DetailDevis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DETAIL_DEVIS_ID_GENERATOR", sequenceName="DETAIL_DEVIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETAIL_DEVIS_ID_GENERATOR")
	private Integer id;

	private String devnum;

	private BigDecimal duree;

	private BigDecimal mtn;

	private BigDecimal mttc;

	private BigDecimal mtva;

	private BigDecimal pu;

	private BigDecimal qte;

	private BigDecimal remise;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	//bi-directional many-to-one association to Taux
	@ManyToOne
	@JoinColumn(name="idttv")
	private Taux taux1;

	//bi-directional many-to-one association to Taux
	@ManyToOne
	@JoinColumn(name="idtr")
	private Taux taux2;

	public DetailDevis() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDevnum() {
		return this.devnum;
	}

	public void setDevnum(String devnum) {
		this.devnum = devnum;
	}

	public BigDecimal getDuree() {
		return this.duree;
	}

	public void setDuree(BigDecimal duree) {
		this.duree = duree;
	}

	public BigDecimal getMtn() {
		return this.mtn;
	}

	public void setMtn(BigDecimal mtn) {
		this.mtn = mtn;
	}

	public BigDecimal getMttc() {
		return this.mttc;
	}

	public void setMttc(BigDecimal mttc) {
		this.mttc = mttc;
	}

	public BigDecimal getMtva() {
		return this.mtva;
	}

	public void setMtva(BigDecimal mtva) {
		this.mtva = mtva;
	}

	public BigDecimal getPu() {
		return this.pu;
	}

	public void setPu(BigDecimal pu) {
		this.pu = pu;
	}

	public BigDecimal getQte() {
		return this.qte;
	}

	public void setQte(BigDecimal qte) {
		this.qte = qte;
	}

	public BigDecimal getRemise() {
		return this.remise;
	}

	public void setRemise(BigDecimal remise) {
		this.remise = remise;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Taux getTaux1() {
		return this.taux1;
	}

	public void setTaux1(Taux taux1) {
		this.taux1 = taux1;
	}

	public Taux getTaux2() {
		return this.taux2;
	}

	public void setTaux2(Taux taux2) {
		this.taux2 = taux2;
	}

}