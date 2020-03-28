package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the taux database table.
 * 
 */
@Entity
@NamedQuery(name="Taux.findAll", query="SELECT t FROM Taux t")
public class Taux extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAUX_ID_GENERATOR", sequenceName="TAUX_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAUX_ID_GENERATOR")
	private Long id;

	private String libelle;

	private BigDecimal mtntaxe;

	//bi-directional many-to-one association to DetailDevi
	@OneToMany(mappedBy="taux1")
	private List<DetailDevi> detailDevis1;

	//bi-directional many-to-one association to DetailDevi
	@OneToMany(mappedBy="taux2")
	private List<DetailDevi> detailDevis2;

	//bi-directional many-to-one association to DetailFacture
	@OneToMany(mappedBy="taux1")
	private List<DetailFacture> detailFactures1;

	//bi-directional many-to-one association to DetailFacture
	@OneToMany(mappedBy="taux2")
	private List<DetailFacture> detailFactures2;

	//bi-directional many-to-one association to RefTypeTaux
	@ManyToOne
	@JoinColumn(name="idttaux")
	private RefTypeTaux refTypeTaux;

	public Taux() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getMtntaxe() {
		return this.mtntaxe;
	}

	public void setMtntaxe(BigDecimal mtntaxe) {
		this.mtntaxe = mtntaxe;
	}

	public List<DetailDevi> getDetailDevis1() {
		return this.detailDevis1;
	}

	public void setDetailDevis1(List<DetailDevi> detailDevis1) {
		this.detailDevis1 = detailDevis1;
	}

	public DetailDevi addDetailDevis1(DetailDevi detailDevis1) {
		getDetailDevis1().add(detailDevis1);
		detailDevis1.setTaux1(this);

		return detailDevis1;
	}

	public DetailDevi removeDetailDevis1(DetailDevi detailDevis1) {
		getDetailDevis1().remove(detailDevis1);
		detailDevis1.setTaux1(null);

		return detailDevis1;
	}

	public List<DetailDevi> getDetailDevis2() {
		return this.detailDevis2;
	}

	public void setDetailDevis2(List<DetailDevi> detailDevis2) {
		this.detailDevis2 = detailDevis2;
	}

	public DetailDevi addDetailDevis2(DetailDevi detailDevis2) {
		getDetailDevis2().add(detailDevis2);
		detailDevis2.setTaux2(this);

		return detailDevis2;
	}

	public DetailDevi removeDetailDevis2(DetailDevi detailDevis2) {
		getDetailDevis2().remove(detailDevis2);
		detailDevis2.setTaux2(null);

		return detailDevis2;
	}

	public List<DetailFacture> getDetailFactures1() {
		return this.detailFactures1;
	}

	public void setDetailFactures1(List<DetailFacture> detailFactures1) {
		this.detailFactures1 = detailFactures1;
	}

	public DetailFacture addDetailFactures1(DetailFacture detailFactures1) {
		getDetailFactures1().add(detailFactures1);
		detailFactures1.setTaux1(this);

		return detailFactures1;
	}

	public DetailFacture removeDetailFactures1(DetailFacture detailFactures1) {
		getDetailFactures1().remove(detailFactures1);
		detailFactures1.setTaux1(null);

		return detailFactures1;
	}

	public List<DetailFacture> getDetailFactures2() {
		return this.detailFactures2;
	}

	public void setDetailFactures2(List<DetailFacture> detailFactures2) {
		this.detailFactures2 = detailFactures2;
	}

	public DetailFacture addDetailFactures2(DetailFacture detailFactures2) {
		getDetailFactures2().add(detailFactures2);
		detailFactures2.setTaux2(this);

		return detailFactures2;
	}

	public DetailFacture removeDetailFactures2(DetailFacture detailFactures2) {
		getDetailFactures2().remove(detailFactures2);
		detailFactures2.setTaux2(null);

		return detailFactures2;
	}

	public RefTypeTaux getRefTypeTaux() {
		return this.refTypeTaux;
	}

	public void setRefTypeTaux(RefTypeTaux refTypeTaux) {
		this.refTypeTaux = refTypeTaux;
	}

}