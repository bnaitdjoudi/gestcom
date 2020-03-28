package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the infotrs database table.
 * 
 */
@Entity
@Table(name="infotrs")
@NamedQuery(name="Infotr.findAll", query="SELECT i FROM Infotr i")
public class Infotr extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INFOTRS_ID_GENERATOR", sequenceName="INFOTRS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INFOTRS_ID_GENERATOR")
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date dateinfo;

	private String paycod;

	private String trsadr;

	private String trsbnq;

	private String trseml;

	private String trsfax;

	private String trstel;

	private String trsvil;

	private String trsweb;

	//bi-directional many-to-one association to Tier
	@ManyToOne
	@JoinColumn(name="codetiers")
	private Tier tier;

	public Infotr() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateinfo() {
		return this.dateinfo;
	}

	public void setDateinfo(Date dateinfo) {
		this.dateinfo = dateinfo;
	}

	public String getPaycod() {
		return this.paycod;
	}

	public void setPaycod(String paycod) {
		this.paycod = paycod;
	}

	public String getTrsadr() {
		return this.trsadr;
	}

	public void setTrsadr(String trsadr) {
		this.trsadr = trsadr;
	}

	public String getTrsbnq() {
		return this.trsbnq;
	}

	public void setTrsbnq(String trsbnq) {
		this.trsbnq = trsbnq;
	}

	public String getTrseml() {
		return this.trseml;
	}

	public void setTrseml(String trseml) {
		this.trseml = trseml;
	}

	public String getTrsfax() {
		return this.trsfax;
	}

	public void setTrsfax(String trsfax) {
		this.trsfax = trsfax;
	}

	public String getTrstel() {
		return this.trstel;
	}

	public void setTrstel(String trstel) {
		this.trstel = trstel;
	}

	public String getTrsvil() {
		return this.trsvil;
	}

	public void setTrsvil(String trsvil) {
		this.trsvil = trsvil;
	}

	public String getTrsweb() {
		return this.trsweb;
	}

	public void setTrsweb(String trsweb) {
		this.trsweb = trsweb;
	}

	public Tier getTier() {
		return this.tier;
	}

	public void setTier(Tier tier) {
		this.tier = tier;
	}

}