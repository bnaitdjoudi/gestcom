package dz.facturation.repository.impl;

import dz.facturation.model.entity.RefCategorie;
import dz.facturation.repository.GenericDao;
import dz.facturation.repository.RefCategorieDao;
import org.springframework.stereotype.Repository;

@Repository
public class RefCategorieDaoImpl extends GenericDao<RefCategorie,Long> implements RefCategorieDao {
    public RefCategorieDaoImpl() {
        super(RefCategorie.class);
    }
}
