package dz.facturation.repository.impl;

import dz.facturation.model.entity.RefCompte;
import dz.facturation.repository.GenericDao;
import dz.facturation.repository.RefCompteDao;
import org.springframework.stereotype.Repository;

/**
 * implementation of RefCompteDao
 */
@Repository
public class RefCompteDaoImpl extends GenericDao<RefCompte,Long> implements RefCompteDao {
    public RefCompteDaoImpl() {
        super(RefCompte.class);
    }
}
