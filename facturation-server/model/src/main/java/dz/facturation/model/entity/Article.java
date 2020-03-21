package dz.facturation.model.entity;


import dz.facturation.audit.EntityAuditListenr;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the article database table.
 */
@Entity
@SelectBeforeUpdate
@EntityListeners(EntityAuditListenr.class)
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article  extends AuditTable implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="ARTICLE_ID_GENERATOR", sequenceName="SEQUENCE_ARTICLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTICLE_ID_GENERATOR")
	private Integer id;

	private String image;

	private BigDecimal minqte;

	private String nomarticle;

	private BigDecimal prixachat;

	private BigDecimal prixvente;

	private String reference;

	private BigDecimal tauxtaxe;

	private String type;

	private String unite;

	//bi-directional many-to-one association to RefCategorie
	@ManyToOne
	@JoinColumn(name="idcateg")
	private RefCategorie refCategorie;

	//bi-directional many-to-one association to RefCompte
	@ManyToOne
	@JoinColumn(name="scfcod")
	private RefCompte refCompte;

	//bi-directional many-to-one association to DetailBl
	@OneToMany(mappedBy="article")
	private List<DetailBl> detailBls;

	//bi-directional many-to-one association to DetailDevis
	@OneToMany(mappedBy="article")
	private List<DetailDevis> detailDevis;

	//bi-directional many-to-one association to DetailFacture
	@OneToMany(mappedBy="article")
	private List<DetailFacture> detailFactures;

	//bi-directional many-to-one association to PrixArticle
	@OneToMany(mappedBy="article")
	private List<PrixArticle> prixArticles;

	public Article() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getMinqte() {
		return this.minqte;
	}

	public void setMinqte(BigDecimal minqte) {
		this.minqte = minqte;
	}

	public String getNomarticle() {
		return this.nomarticle;
	}

	public void setNomarticle(String nomarticle) {
		this.nomarticle = nomarticle;
	}

	public BigDecimal getPrixachat() {
		return this.prixachat;
	}

	public void setPrixachat(BigDecimal prixachat) {
		this.prixachat = prixachat;
	}

	public BigDecimal getPrixvente() {
		return this.prixvente;
	}

	public void setPrixvente(BigDecimal prixvente) {
		this.prixvente = prixvente;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BigDecimal getTauxtaxe() {
		return this.tauxtaxe;
	}

	public void setTauxtaxe(BigDecimal tauxtaxe) {
		this.tauxtaxe = tauxtaxe;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnite() {
		return this.unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public RefCategorie getRefCategorie() {
		return this.refCategorie;
	}

	public void setRefCategorie(RefCategorie refCategorie) {
		this.refCategorie = refCategorie;
	}

	public RefCompte getRefCompte() {
		return this.refCompte;
	}

	public void setRefCompte(RefCompte refCompte) {
		this.refCompte = refCompte;
	}

	public List<DetailBl> getDetailBls() {
		return this.detailBls;
	}

	public void setDetailBls(List<DetailBl> detailBls) {
		this.detailBls = detailBls;
	}

	public DetailBl addDetailBl(DetailBl detailBl) {
		getDetailBls().add(detailBl);
		detailBl.setArticle(this);

		return detailBl;
	}

	public DetailBl removeDetailBl(DetailBl detailBl) {
		getDetailBls().remove(detailBl);
		detailBl.setArticle(null);

		return detailBl;
	}

	public List<DetailDevis> getDetailDevis() {
		return this.detailDevis;
	}

	public void setDetailDevis(List<DetailDevis> detailDevis) {
		this.detailDevis = detailDevis;
	}

	public DetailDevis addDetailDevi(DetailDevis detailDevi) {
		getDetailDevis().add(detailDevi);
		detailDevi.setArticle(this);

		return detailDevi;
	}

	public DetailDevis removeDetailDevi(DetailDevis detailDevi) {
		getDetailDevis().remove(detailDevi);
		detailDevi.setArticle(null);

		return detailDevi;
	}

	public List<DetailFacture> getDetailFactures() {
		return this.detailFactures;
	}

	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public DetailFacture addDetailFacture(DetailFacture detailFacture) {
		getDetailFactures().add(detailFacture);
		detailFacture.setArticle(this);

		return detailFacture;
	}

	public DetailFacture removeDetailFacture(DetailFacture detailFacture) {
		getDetailFactures().remove(detailFacture);
		detailFacture.setArticle(null);

		return detailFacture;
	}

	public List<PrixArticle> getPrixArticles() {
		return this.prixArticles;
	}

	public void setPrixArticles(List<PrixArticle> prixArticles) {
		this.prixArticles = prixArticles;
	}

	public PrixArticle addPrixArticle(PrixArticle prixArticle) {
		getPrixArticles().add(prixArticle);
		prixArticle.setArticle(this);

		return prixArticle;
	}

	public PrixArticle removePrixArticle(PrixArticle prixArticle) {
		getPrixArticles().remove(prixArticle);
		prixArticle.setArticle(null);

		return prixArticle;
	}

}