package dz.facturation.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import dz.facturation.audit.EntityAuditListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * class pour l'audit des table
 */

@MappedSuperclass
@EntityListeners(EntityAuditListener.class)
public abstract class AuditTable<ID> {


    //date de creation
    @Column(name = "date_create")
    @CreatedDate
    private LocalDateTime dateCreate;

    //id de l'utilisateur qui créé la donnée
    @Column(name = "user_create")
    @CreatedBy
    private String userCreate;

    //date de la dernière mis à jour
    @Column(name = "date_maj")
    @LastModifiedDate
    private LocalDateTime dateMaj;

    public abstract ID getId();


    public LocalDateTime getDateCreate() {

        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public LocalDateTime getDateMaj() {
        return dateMaj;
    }

    public void setDateMaj(LocalDateTime dateMaj) {
        this.dateMaj = dateMaj;
    }
}
