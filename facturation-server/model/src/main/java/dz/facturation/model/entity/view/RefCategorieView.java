package dz.facturation.model.entity.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import dz.facturation.model.entity.AuditTable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * entity for view ref_categorie_view
 */
@Entity
@Table(name="ref_categorie_view")
public class RefCategorieView  extends AuditTable<Long> {


    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String libelle;

    @Column(name = "number_of_article")
    private long numberOfArticle;

    public RefCategorieView() {
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

    public long getNumberOfArticle() {
        return numberOfArticle;
    }

    public void setNumberOfArticle(long numberOfArticle) {
        this.numberOfArticle = numberOfArticle;
    }

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
    public LocalDateTime getDateCreate(){
        return super.getDateCreate();
    }

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy@HH:mm:ss")
    public LocalDateTime getDateMaj(){
        return super.getDateMaj();
    }
}
