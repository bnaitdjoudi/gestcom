package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ref_categ_tiers database table.
 * 
 */
@Entity
@Table(name="ref_categ_tiers")
@NamedQuery(name="RefCategTier.findAll", query="SELECT r FROM RefCategTier r")
public class RefCategTier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String libelle;

	//bi-directional many-to-one association to Tier
	@OneToMany(mappedBy="refCategTier")
	private List<Tier> tiers;

	public RefCategTier() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Tier> getTiers() {
		return this.tiers;
	}

	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}

	public Tier addTier(Tier tier) {
		getTiers().add(tier);
		tier.setRefCategTier(this);

		return tier;
	}

	public Tier removeTier(Tier tier) {
		getTiers().remove(tier);
		tier.setRefCategTier(null);

		return tier;
	}

}