package dz.facturation.tools;

import dz.facturation.model.dto.OperatorValue;
import dz.facturation.model.entity.AuditTable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;

/**
 * tool for process criteria
 */
public class CriteriaTool {

    /**
     * build predicate form criteria
     *
     * @param root     hibernate object indicate the entiry root of query
     * @param builder  CriteriaBuilder of hibernate
     * @param criteria filtering citeria from CritereQuery
     * @return result of predicate
     */
    public static Predicate buildPredicate(Root<? extends AuditTable> root, CriteriaBuilder builder, Map<String, OperatorValue> criteria) {
        Predicate mainPredicate = builder.conjunction();

        for (Map.Entry<String, OperatorValue> entry : criteria.entrySet()) {
            mainPredicate = builder.and(mainPredicate, predicateFromEntry(entry, root, builder));
        }
        return mainPredicate;
    }


    /**
     * generate predicate form one field and OperatorValue
     * @param entry contents field and OperatorValue
     * @param root hibernate object indicate the entiry root of query
     * @param builder CriteriaBuilder of hibernate
     * @return result of predicate
     */
    private static Predicate predicateFromEntry(Map.Entry<String, OperatorValue> entry, Root<? extends AuditTable> root, CriteriaBuilder builder) {
        Predicate mainPredicate;
        switch (entry.getValue().getOperator()) {
            case EQUAL: {
                mainPredicate = builder.equal(root.get(entry.getKey()), entry.getValue().getValue());
                break;
            }
            case LIKE: {
                mainPredicate = builder.like(root.get(entry.getKey()), "%"+entry.getValue().getValue()+"%");
                break;
            }
            default: {
                mainPredicate = builder.conjunction();
            }
        }
        return mainPredicate;
    }

}
