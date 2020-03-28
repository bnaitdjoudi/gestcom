package dz.facturation.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ref_type_tiers database table.
 * 
 */
@Entity
@Table(name="ref_type_tiers")
@NamedQuery(name="RefTypeTier.findAll", query="SELECT r FROM RefTypeTier r")
public class RefTypeTier extends AuditTable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REF_TYPE_TIERS_ID_GENERATOR", sequenceName="REF_TYPE_TIERS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REF_TYPE_TIERS_ID_GENERATOR")
	private Long id;

	private String tirlib;

	//bi-directional many-to-one association to Tier
	@OneToMany(mappedBy="refTypeTier")
	private List<Tier> tiers;

	public RefTypeTier() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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