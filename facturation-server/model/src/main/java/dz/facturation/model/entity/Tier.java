package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tiers database table.
 * 
 */
@Entity
@Table(name="tiers")
@NamedQuery(name="Tier.findAll", query="SELECT t FROM Tier t")
public class Tier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String trscod;

	private String trsnif;

	private Integer trsnis;

	private String trsnom;

	private String trsrc;

	//bi-directional many-to-one association to Bl
	@OneToMany(mappedBy="tier")
	private List<Bl> bls;

	//bi-directional many-to-one association to Devis
	@OneToMany(mappedBy="tier")
	private List<Devis> devis;

	//bi-directional many-to-one association to Facture
	@OneToMany(mappedBy="tier")
	private List<Facture> factures;

	//bi-directional many-to-one association to Infotr
	@OneToMany(mappedBy="tier")
	private List<Infotr> infotrs;

	//bi-directional many-to-one association to RefCategTier
	@ManyToOne
	@JoinColumn(name="idcatiers")
	private RefCategTier refCategTier;

	//bi-directional many-to-one association to RefCompte
	@ManyToOne
	@JoinColumn(name="scfcod")
	private RefCompte refCompte;

	//bi-directional many-to-one association to RefTypeTier
	@ManyToOne
	@JoinColumn(name="tircod")
	private RefTypeTier refTypeTier;

	public Tier() {
	}

	public String getTrscod() {
		return this.trscod;
	}

	public void setTrscod(String trscod) {
		this.trscod = trscod;
	}

	public String getTrsnif() {
		return this.trsnif;
	}

	public void setTrsnif(String trsnif) {
		this.trsnif = trsnif;
	}

	public Integer getTrsnis() {
		return this.trsnis;
	}

	public void setTrsnis(Integer trsnis) {
		this.trsnis = trsnis;
	}

	public String getTrsnom() {
		return this.trsnom;
	}

	public void setTrsnom(String trsnom) {
		this.trsnom = trsnom;
	}

	public String getTrsrc() {
		return this.trsrc;
	}

	public void setTrsrc(String trsrc) {
		this.trsrc = trsrc;
	}

	public List<Bl> getBls() {
		return this.bls;
	}

	public void setBls(List<Bl> bls) {
		this.bls = bls;
	}

	public Bl addBl(Bl bl) {
		getBls().add(bl);
		bl.setTier(this);

		return bl;
	}

	public Bl removeBl(Bl bl) {
		getBls().remove(bl);
		bl.setTier(null);

		return bl;
	}

	public List<Devis> getDevis() {
		return this.devis;
	}

	public void setDevis(List<Devis> devis) {
		this.devis = devis;
	}

	public Devis addDevi(Devis devi) {
		getDevis().add(devi);
		devi.setTier(this);

		return devi;
	}

	public Devis removeDevi(Devis devi) {
		getDevis().remove(devi);
		devi.setTier(null);

		return devi;
	}

	public List<Facture> getFactures() {
		return this.factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public Facture addFacture(Facture facture) {
		getFactures().add(facture);
		facture.setTier(this);

		return facture;
	}

	public Facture removeFacture(Facture facture) {
		getFactures().remove(facture);
		facture.setTier(null);

		return facture;
	}

	public List<Infotr> getInfotrs() {
		return this.infotrs;
	}

	public void setInfotrs(List<Infotr> infotrs) {
		this.infotrs = infotrs;
	}

	public Infotr addInfotr(Infotr infotr) {
		getInfotrs().add(infotr);
		infotr.setTier(this);

		return infotr;
	}

	public Infotr removeInfotr(Infotr infotr) {
		getInfotrs().remove(infotr);
		infotr.setTier(null);

		return infotr;
	}

	public RefCategTier getRefCategTier() {
		return this.refCategTier;
	}

	public void setRefCategTier(RefCategTier refCategTier) {
		this.refCategTier = refCategTier;
	}

	public RefCompte getRefCompte() {
		return this.refCompte;
	}

	public void setRefCompte(RefCompte refCompte) {
		this.refCompte = refCompte;
	}

	public RefTypeTier getRefTypeTier() {
		return this.refTypeTier;
	}

	public void setRefTypeTier(RefTypeTier refTypeTier) {
		this.refTypeTier = refTypeTier;
	}

}