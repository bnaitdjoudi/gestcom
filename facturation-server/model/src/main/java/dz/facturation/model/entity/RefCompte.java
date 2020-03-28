package dz.facturation.model.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ref_compte database table.
 */
@Entity
@Table(name = "ref_compte")
@NamedQuery(name = "RefCompte.findAll", query = "SELECT r FROM RefCompte r")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RefCompte extends AuditTable<Long> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "REF_COMPTE_ID_GENERATOR", sequenceName = "REF_COMPTE_ID_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REF_COMPTE_ID_GENERATOR")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date datecmp;
    @JsonIgnore
    private String libelle;

    private String scfcod;

    //bi-directional many-to-one association to Article
    @OneToMany(mappedBy = "refCompte",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Article> articles;

    //bi-directional many-to-one association to Tier
    @OneToMany(mappedBy = "refCompte")
    @JsonIgnore
    private List<Tier> tiers;

    public RefCompte() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatecmp() {
        return this.datecmp;
    }

    public void setDatecmp(Date datecmp) {
        this.datecmp = datecmp;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getScfcod() {
        return this.scfcod;
    }

    public void setScfcod(String scfcod) {
        this.scfcod = scfcod;
    }

    @JsonIgnore
    public List<Article> getArticles() {
        return this.articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article addArticle(Article article) {
        getArticles().add(article);
        article.setRefCompte(this);

        return article;
    }

    public Article removeArticle(Article article) {
        getArticles().remove(article);
        article.setRefCompte(null);

        return article;
    }

    @JsonIgnore
    public List<Tier> getTiers() {
        return this.tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public Tier addTier(Tier tier) {
        getTiers().add(tier);
        tier.setRefCompte(this);

        return tier;
    }

    public Tier removeTier(Tier tier) {
        getTiers().remove(tier);
        tier.setRefCompte(null);

        return tier;
    }

}