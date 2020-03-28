package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tiers database table.
 * 
 */
@Entity
@Table(name="tiers")
@NamedQuery(name="Tier.findAll", query="SELECT t FROM Tier t")
public class Tier extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIERS_ID_GENERATOR", sequenceName="TIERS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIERS_ID_GENERATOR")
	private Long id;

	private String trscod;

	private String trsnif;

	private Integer trsnis;

	private String trsnom;

	private String trsrc;

	//bi-directional many-to-one association to Devi
	@OneToMany(mappedBy="tier")
	private List<Devi> devis;

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
	@JoinColumn(name="idcompte")
	private RefCompte refCompte;

	//bi-directional many-to-one association to RefTypeTier
	@ManyToOne
	@JoinColumn(name="idtyptiers")
	private RefTypeTier refTypeTier;

	public Tier() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Devi> getDevis() {
		return this.devis;
	}

	public void setDevis(List<Devi> devis) {
		this.devis = devis;
	}

	public Devi addDevi(Devi devi) {
		getDevis().add(devi);
		devi.setTier(this);

		return devi;
	}

	public Devi removeDevi(Devi devi) {
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