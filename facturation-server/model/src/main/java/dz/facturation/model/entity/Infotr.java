package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the infotrs database table.
 * 
 */
@Entity
@Table(name="infotrs")
@NamedQuery(name="Infotr.findAll", query="SELECT i FROM Infotr i")
public class Infotr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long infocode;

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
	@JoinColumn(name="trscod")
	private Tier tier;

	public Infotr() {
	}

	public long getInfocode() {
		return this.infocode;
	}

	public void setInfocode(long infocode) {
		this.infocode = infocode;
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