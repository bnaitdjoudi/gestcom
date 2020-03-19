package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bl database table.
 * 
 */
@Entity
@NamedQuery(name="Bl.findAll", query="SELECT b FROM Bl b")
public class Bl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BL_ID_GENERATOR", sequenceName="BL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BL_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date bldat;

	private String blnum;

	//bi-directional many-to-one association to Devis
	@ManyToOne
	@JoinColumn(name="iddevis")
	private Devis devi;

	//bi-directional many-to-one association to Facture
	@ManyToOne
	@JoinColumn(name="idfacture")
	private Facture facture;

	//bi-directional many-to-one association to Tier
	@ManyToOne
	@JoinColumn(name="trscod")
	private Tier tier;

	//bi-directional many-to-one association to DetailBl
	@OneToMany(mappedBy="bl")
	private List<DetailBl> detailBls;

	public Bl() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBldat() {
		return this.bldat;
	}

	public void setBldat(Date bldat) {
		this.bldat = bldat;
	}

	public String getBlnum() {
		return this.blnum;
	}

	public void setBlnum(String blnum) {
		this.blnum = blnum;
	}

	public Devis getDevi() {
		return this.devi;
	}

	public void setDevi(Devis devi) {
		this.devi = devi;
	}

	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Tier getTier() {
		return this.tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

	public List<DetailBl> getDetailBls() {
		return this.detailBls;
	}

	public void setDetailBls(List<DetailBl> detailBls) {
		this.detailBls = detailBls;
	}

	public DetailBl addDetailBl(DetailBl detailBl) {
		getDetailBls().add(detailBl);
		detailBl.setBl(this);

		return detailBl;
	}

	public DetailBl removeDetailBl(DetailBl detailBl) {
		getDetailBls().remove(detailBl);
		detailBl.setBl(null);

		return detailBl;
	}

}