package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ref_type_tiers database table.
 * 
 */
@Entity
@Table(name="ref_type_tiers")
@NamedQuery(name="RefTypeTier.findAll", query="SELECT r FROM RefTypeTier r")
public class RefTypeTier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tircod;

	private String tirlib;

	//bi-directional many-to-one association to Tier
	@OneToMany(mappedBy="refTypeTier")
	private List<Tier> tiers;

	public RefTypeTier() {
	}

	public String getTircod() {
		return this.tircod;
	}

	public void setTircod(String tircod) {
		this.tircod = tircod;
	}

	public String getTirlib() {
		return this.tirlib;
	}

	public void setTirlib(String tirlib) {
		this.tirlib = tirlib;
	}

	public List<Tier> getTiers() {
		return this.tiers;
	}

	public void setTiers(List<Tier> tiers) {
		this.tiers = tiers;
	}

	public Tier addTier(Tier tier) {
		getTiers().add(tier);
		tier.setRefTypeTier(this);

		return tier;
	}

	public Tier removeTier(Tier tier) {
		getTiers().remove(tier);
		tier.setRefTypeTier(null);

		return tier;
	}

}