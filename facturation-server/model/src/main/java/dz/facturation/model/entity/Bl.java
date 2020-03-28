package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the bl database table.
 * 
 */
@Entity
@NamedQuery(name="Bl.findAll", query="SELECT b FROM Bl b")
public class Bl extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BL_ID_GENERATOR", sequenceName="BL_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BL_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date bldat;

	private String blnum;

	@Column(name="date_create")
	private Timestamp dateCreate;

	@Column(name="date_maj")
	private Timestamp dateMaj;

	private Long idtiers;

	//bi-directional many-to-one association to Devi
	@ManyToOne
	@JoinColumn(name="iddevis")
	private Devi devi;

	//bi-directional many-to-one association to Facture
	@ManyToOne
	@JoinColumn(name="idfacture")
	private Facture facture;

	//bi-directional many-to-one association to DetailBl
	@OneToMany(mappedBy="bl")
	private List<DetailBl> detailBls;

	public Bl() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public Long getIdtiers() {
		return this.idtiers;
	}

	public void setIdtiers(Long idtiers) {
		this.idtiers = idtiers;
	}

	public Devi getDevi() {
		return this.devi;
	}

	public void setDevi(Devi devi) {
		this.devi = devi;
	}

	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
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