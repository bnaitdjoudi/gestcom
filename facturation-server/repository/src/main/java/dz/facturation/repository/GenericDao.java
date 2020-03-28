package dz.facturation.repository;

import dz.facturation.model.entity.AuditTable;

import java.util.List;
import java.util.Optional;

/**
 * Generic dao implementation
 * @param <E>
 * @param <ID>
 */
public class GenericDao<E extends AuditTable<ID>, ID>  extends ReadOnlyGenericDao<E,ID> implements IGenericDao<E, ID> {


    public GenericDao(Class<E> clazz) {
        super(clazz);
    }

    @Override
    public E create(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void deleteBy(ID id) {
        Optional<E> entityOptional = findById(id);
        if (!entityOptional.isEmpty()) {
            entityManager.remove(entityOptional.get());
        }
    }

    @Override
    public void deleteMas(List<ID> ids) {
        entityManager
                .createQuery("DELETE FROM " + clazz.getCanonicalName() + " e WHERE e.id IN (:ids)")
                .setParameter("ids", ids)
                .executeUpdate();
    }

    @Override
    public Optional<E> update(E entity) {
        Optional<E> optionalEntity = findById(entity.getId());
        if (!optionalEntity.isEmpty()) {
            entityManager.merge(entity);
            return Optional.of(entity);
        } else {
            return Optional.empty();
        }
    }

}
