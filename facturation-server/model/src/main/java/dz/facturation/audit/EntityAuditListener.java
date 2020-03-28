package dz.facturation.audit;

import dz.facturation.model.entity.AuditTable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Listener d'entity
 */
public class EntityAuditListener {

    @PrePersist
    public void setCreatedOn(AuditTable audit) {
        audit.setDateCreate(LocalDateTime.now());
        //utilisateur par
        audit.setUserCreate("coucou");
    }

    @PreUpdate
    public void setUpdatedOn(AuditTable audit) {
        audit.setDateMaj(LocalDateTime.now());
    }


}
