package dz.facturation.repository.impl;

import dz.facturation.model.entity.view.RefCategorieView;
import dz.facturation.repository.IRefCategorieViewDao;
import dz.facturation.repository.ReadOnlyGenericDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * refCategorieDao implementation
 */
@Repository
public class RefCategorieViewDao extends ReadOnlyGenericDao<RefCategorieView,Long> implements IRefCategorieViewDao {
    public RefCategorieViewDao() {
        super(RefCategorieView.class);
    }
}
