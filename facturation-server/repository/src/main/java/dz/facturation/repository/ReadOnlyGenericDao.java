package dz.facturation.repository;

import dz.facturation.model.dto.CritereQuery;
import dz.facturation.model.dto.OperatorValue;
import dz.facturation.model.dto.QueryResult;
import dz.facturation.model.dto.SortDir;
import dz.facturation.model.entity.AuditTable;
import dz.facturation.tools.CriteriaTool;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReadOnlyGenericDao<E extends AuditTable<ID>, ID> implements IReadOnlyGenericDao<E, ID> {

    @PersistenceContext
    protected EntityManager entityManager;
    Class<E> clazz;

    public ReadOnlyGenericDao(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Optional<E> findById(ID id) {
        E entity = entityManager.find(clazz, id);
        return Optional.of(entity);
    }

    @Override
    public List<E> findAll() {
        TypedQuery<E> query = entityManager.createQuery("SELECT e FROM " + clazz.getCanonicalName() + " e", clazz);
        return query.getResultList();
    }

    @Override
    public QueryResult<E> processCriteriaQuery(CritereQuery critereQuery) {
        Long count = (Long) countByCriteria(critereQuery.getCriteria());
        List<E> rows = findByCriteriaAndSorting(
                critereQuery.getDataProperties(),
                critereQuery.getCriteria(),
                critereQuery.getSorts(),
                critereQuery.getPageNumber(),
                critereQuery.getSize());
        return new QueryResult<E>(critereQuery.getPageNumber(), critereQuery.getSize(), count.intValue(), rows);
    }

    @Override
    public List<E> findByCriteriaAndSorting(List<String> datas, Map<String,
            OperatorValue> criteria, Map<String, SortDir> sort, int pageNumber, int size) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> criteriaQuery = builder.createQuery(clazz);
        Root<E> root = criteriaQuery.from(clazz);
        if (datas != null) {
            criteriaQuery = criteriaQuery.multiselect(generateSelection(root, datas))
                    .where(CriteriaTool.buildPredicate(root, builder, criteria))
                    .orderBy(generateOrder(root,sort));
        } else {
            criteriaQuery = criteriaQuery.select(root)
                    .where(CriteriaTool.buildPredicate(root, builder, criteria))
                    .orderBy(generateOrder(root,sort));
        }

        TypedQuery<E> query = entityManager.createQuery(criteriaQuery);
        if (size > 0) {
            query.setMaxResults(size);
        }
        return new ArrayList<>(query.setFirstResult((pageNumber - 1) * size).getResultList());
    }

    @Override
    public Number countAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Number> criteriaQuery = builder.createQuery(Number.class);
        Root<E> root = criteriaQuery.from(clazz);
        criteriaQuery = criteriaQuery.select(builder.count(root)).where(builder.conjunction());
        Query query = entityManager.createQuery(criteriaQuery);
        return ((Number) query.getSingleResult());
    }

    @Override
    public Number countByCriteria(Map<String, OperatorValue> criteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Number> criteriaQuery = builder.createQuery(Number.class);
        Root<E> root = criteriaQuery.from(clazz);
        criteriaQuery = criteriaQuery.select(builder.count(root)).where(CriteriaTool.buildPredicate(root, builder, criteria));
        Query query = entityManager.createQuery(criteriaQuery);
        return ((Number) query.getSingleResult());
    }

    private List<Selection<?>> generateSelection(Root<E> root, List<String> datas) {
        List<Selection<?>> selectionList = new ArrayList<>();
        for (String data : datas) {
            selectionList.add(root.get(data));
        }
        return selectionList;
    }

    private List<Order> generateOrder(Root<E> root, Map<String, SortDir> sorts) {
        List<Order> orderList = new ArrayList<>();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        for (Map.Entry<String, SortDir> sort : sorts.entrySet()) {
            if (sort.getValue() == SortDir.ASC) {
                orderList.add(builder.asc(root.get(sort.getKey())));
            } else {
                orderList.add(builder.desc(root.get(sort.getKey())));
            }
        }
        return orderList;
    }


}
