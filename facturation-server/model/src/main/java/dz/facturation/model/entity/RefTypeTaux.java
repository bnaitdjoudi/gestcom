package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ref_type_taux database table.
 * 
 */
@Entity
@Table(name="ref_type_taux")
@NamedQuery(name="RefTypeTaux.findAll", query="SELECT r FROM RefTypeTaux r")
public class RefTypeTaux implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idttaux;

	private String libelle;

	//bi-directional many-to-one association to Taux
	@OneToMany(mappedBy="refTypeTaux")
	private List<Taux> tauxs;

	public RefTypeTaux() {
	}

	public String getIdttaux() {
		return this.idttaux;
	}

	public void setIdttaux(String idttaux) {
		this.idttaux = idttaux;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Taux> getTauxs() {
		return this.tauxs;
	}

	public void setTauxs(List<Taux> tauxs) {
		this.tauxs = tauxs;
	}

	public Taux addTaux(Taux taux) {
		getTauxs().add(taux);
		taux.setRefTypeTaux(this);

		return taux;
	}

	public Taux removeTaux(Taux taux) {
		getTauxs().remove(taux);
		taux.setRefTypeTaux(null);

		return taux;
	}

}