package dz.facturation.model.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * object contents all criteria and paging information
 */
public class CritereQuery implements Serializable {

    //page number
    private int pageNumber;
    //number of elements
    private int size;
    //map for sort for each field
    private Map<String, SortDir> sorts = new HashMap<>();
    //map contents value, operator for each field
    private Map<String, OperatorValue> criteria = new HashMap<>();
    //list of requested properties
    private List<String> dataProperties;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, SortDir> getSorts() {
        return sorts;
    }

    public void setSorts(Map<String, SortDir> sorts) {
        this.sorts = sorts;
    }

    public Map<String, OperatorValue> getCriteria() {
        return criteria;
    }

    public void setCriteria(Map<String, OperatorValue> criteria) {
        this.criteria = criteria;
    }

    public List<String> getDataProperties() {
        return dataProperties;
    }

    public void setDataProperties(List<String> dataProperties) {
        this.dataProperties = dataProperties;
    }

}
