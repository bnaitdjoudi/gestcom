package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the devis database table.
 * 
 */
@Entity
@NamedQuery(name="Devis.findAll", query="SELECT d FROM Devis d")
public class Devis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVIS_ID_GENERATOR", sequenceName="DEVIIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVIS_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date devdat;

	private BigDecimal devmtn;

	private BigDecimal devremise;

	private BigDecimal devtmb;

	private BigDecimal devttc;

	private BigDecimal devtva;

	private String mrgcod;

	//bi-directional many-to-one association to Bl
	@OneToMany(mappedBy="devi")
	private List<Bl> bls;

	//bi-directional many-to-one association to Tier
	@ManyToOne
	@JoinColumn(name="trscod")
	private Tier tier;

	public Devis() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDevdat() {
		return this.devdat;
	}

	public void setDevdat(Date devdat) {
		this.devdat = devdat;
	}

	public BigDecimal getDevmtn() {
		return this.devmtn;
	}

	public void setDevmtn(BigDecimal devmtn) {
		this.devmtn = devmtn;
	}

	public BigDecimal getDevremise() {
		return this.devremise;
	}

	public void setDevremise(BigDecimal devremise) {
		this.devremise = devremise;
	}

	public BigDecimal getDevtmb() {
		return this.devtmb;
	}

	public void setDevtmb(BigDecimal devtmb) {
		this.devtmb = devtmb;
	}

	public BigDecimal getDevttc() {
		return this.devttc;
	}

	public void setDevttc(BigDecimal devttc) {
		this.devttc = devttc;
	}

	public BigDecimal getDevtva() {
		return this.devtva;
	}

	public void setDevtva(BigDecimal devtva) {
		this.devtva = devtva;
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
		bl.setDevi(this);

		return bl;
	}

	public Bl removeBl(Bl bl) {
		getBls().remove(bl);
		bl.setDevi(null);

		return bl;
	}

	public Tier getTier() {
		return this.tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

}