package dz.facturation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * class for contents result of criteria query with paging information
 * @param <T>
 */
public class QueryResult<T> {
    //number of actual page
    private int pageNumber;
    // number of pages
    private int totalOfPages;
    //number of returned elements
    private int numberOfElements;
    //total of all elements
    private int totalOfElements;
    //List of resulting elements
    private List<T> rows;

    public QueryResult() {
    }

    public QueryResult(int pageNumber,int size, int totalOfElements, List<T> rows) {
        this.pageNumber = pageNumber!=0?pageNumber:1;
        this.totalOfElements = totalOfElements;
        this.rows = rows;
        this.numberOfElements = rows.size();
        this.totalOfPages = size > 0 ?totalOfElements%size ==0? totalOfElements/size:(totalOfElements/size)+1:1;

    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalOfPages() {
        return totalOfPages;
    }

    public void setTotalOfPages(int totalOfPages) {
        this.totalOfPages = totalOfPages;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getTotalOfElements() {
        return totalOfElements;
    }

    public void setTotalOfElements(int totalOfElements) {
        this.totalOfElements = totalOfElements;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
