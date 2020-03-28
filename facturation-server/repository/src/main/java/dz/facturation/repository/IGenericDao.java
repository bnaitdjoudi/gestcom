package dz.facturation.repository;

import dz.facturation.model.entity.AuditTable;

import java.util.List;
import java.util.Optional;

/**
 * Generic dao
 * @param <E> entity type
 * @param <ID> id type
 */
public interface IGenericDao<E extends AuditTable,ID> extends IReadOnlyGenericDao<E,ID>{
    /**
     * create entity (persist)
     * @param entity jpa entity
     * @return entity created
     */
    E create (E entity);

    /**
     * delete by Id
     * @param id id of entity
     */
    void deleteBy(ID id);

    /**
     * delete entities by list ids
     * @param ids list of ids
     */
    void deleteMas(List<ID> ids);

    /**
     * update entity
     * @param entity to update
     * @return optional of entity
     */
    Optional<E> update(E entity);

}
