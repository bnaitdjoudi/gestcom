package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the devis database table.
 * 
 */
@Entity
@Table(name="devis")
@NamedQuery(name="Devi.findAll", query="SELECT d FROM Devi d")
public class Devi extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEVIS_ID_GENERATOR", sequenceName="DEVIS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEVIS_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date devdat;

	private BigDecimal devmtn;

	private String devnum;

	private BigDecimal devremise;

	private BigDecimal devtmb;

	private BigDecimal devttc;

	private BigDecimal devtva;

	private String mrgcod;

	//bi-directional many-to-one association to Bl
	@OneToMany(mappedBy="devi")
	private List<Bl> bls;

	//bi-directional many-to-one association to DetailDevi
	@OneToMany(mappedBy="devi")
	private List<DetailDevi> detailDevis;

	//bi-directional many-to-one association to Tier
	@ManyToOne
	@JoinColumn(name="codetiers")
	private Tier tier;

	public Devi() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getDevnum() {
		return this.devnum;
	}

	public void setDevnum(String devnum) {
		this.devnum = devnum;
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

	public List<DetailDevi> getDetailDevis() {
		return this.detailDevis;
	}

	public void setDetailDevis(List<DetailDevi> detailDevis) {
		this.detailDevis = detailDevis;
	}

	public DetailDevi addDetailDevi(DetailDevi detailDevi) {
		getDetailDevis().add(detailDevi);
		detailDevi.setDevi(this);

		return detailDevi;
	}

	public DetailDevi removeDetailDevi(DetailDevi detailDevi) {
		getDetailDevis().remove(detailDevi);
		detailDevi.setDevi(null);

		return detailDevi;
	}

	public Tier getTier() {
		return this.tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

}