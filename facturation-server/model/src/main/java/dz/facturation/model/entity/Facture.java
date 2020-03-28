package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the facture database table.
 * 
 */
@Entity
@NamedQuery(name="Facture.findAll", query="SELECT f FROM Facture f")
public class Facture extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACTURE_ID_GENERATOR", sequenceName="FACTURE_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACTURE_ID_GENERATOR")
	private Long id;

	private String facnum;

	@Temporal(TemporalType.DATE)
	private Date factdat;

	private BigDecimal factmtn;

	private BigDecimal factremise;

	private BigDecimal facttmb;

	private BigDecimal factttc;

	private BigDecimal facttva;

	private String mrgcod;

	//bi-directional many-to-one association to Bl
	@OneToMany(mappedBy="facture")
	private List<Bl> bls;

	//bi-directional many-to-one association to DetailFacture
	@OneToMany(mappedBy="facture")
	private List<DetailFacture> detailFactures;

	//bi-directional many-to-one association to Tier
	@ManyToOne
	@JoinColumn(name="codetiers")
	private Tier tier;

	public Facture() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacnum() {
		return this.facnum;
	}

	public void setFacnum(String facnum) {
		this.facnum = facnum;
	}

	public Date getFactdat() {
		return this.factdat;
	}

	public void setFactdat(Date factdat) {
		this.factdat = factdat;
	}

	public BigDecimal getFactmtn() {
		return this.factmtn;
	}

	public void setFactmtn(BigDecimal factmtn) {
		this.factmtn = factmtn;
	}

	public BigDecimal getFactremise() {
		return this.factremise;
	}

	public void setFactremise(BigDecimal factremise) {
		this.factremise = factremise;
	}

	public BigDecimal getFacttmb() {
		return this.facttmb;
	}

	public void setFacttmb(BigDecimal facttmb) {
		this.facttmb = facttmb;
	}

	public BigDecimal getFactttc() {
		return this.factttc;
	}

	public void setFactttc(BigDecimal factttc) {
		this.factttc = factttc;
	}

	public BigDecimal getFacttva() {
		return this.facttva;
	}

	public void setFacttva(BigDecimal facttva) {
		this.facttva = facttva;
	}

	public String getMrgcod() {
		return this.mrgcod;
	}

	public void setMrgcod(String mrgcod) {
		this.mrgcod = mrgcod;
	}

	public List<Bl> getBls() {
		return this.bls;
	}

	public void setBls(List<Bl> bls) {
		this.bls = bls;
	}

	public Bl addBl(Bl bl) {
		getBls().add(bl);
		bl.setFacture(this);

		return bl;
	}

	public Bl removeBl(Bl bl) {
		getBls().remove(bl);
		bl.setFacture(null);

		return bl;
	}

	public List<DetailFacture> getDetailFactures() {
		return this.detailFactures;
	}

	public void setDetailFactures(List<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public DetailFacture addDetailFacture(DetailFacture detailFacture) {
		getDetailFactures().add(detailFacture);
		detailFacture.setFacture(this);

		return detailFacture;
	}

	public DetailFacture removeDetailFacture(DetailFacture detailFacture) {
		getDetailFactures().remove(detailFacture);
		detailFacture.setFacture(null);

		return detailFacture;
	}

	public Tier getTier() {
		return this.tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

}