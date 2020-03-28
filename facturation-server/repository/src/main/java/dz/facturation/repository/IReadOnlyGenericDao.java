package dz.facturation.repository;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.OperatorValue;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.dto.SortDir;
import dz.facturation.model.entity.AuditTable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Generic dao for read only
 * @param <E> entity type
 * @param <ID> id type
 */
public interface IReadOnlyGenericDao<E extends AuditTable,ID> {


    /**
     * find by id
     * @param id
     * @return Optional of entity
     */
    Optional<E> findById(ID id);

    /**
     * find all entities
     * @return list of entities
     */
    List<E> findAll();

    /**
     * find by criteria and pagination information
     * @param critereQuery object contents criteria and pagination information
     * @return QueryResult contents rows result and information of query
     */
    QueryResult<E> processCriteriaQuery(CritereQuery critereQuery);

    /**
     * find by criteria
     * @param criteria of filtering
     * @param sort information about sorting
     * @return list of row from criteria
     */
    List<E> findByCriteriaAndSorting(List<String> datas, Map<String, OperatorValue> criteria, Map<String, SortDir> sort, int pageNumber, int size);

    /**
     * number of row for entity table
     * @return number of rows
     */
    Number countAll();

    /**
     * count with criteria
     * @param criteria for query
     * @return number of elements
     */
    Number countByCriteria(Map<String, OperatorValue> criteria);
}
