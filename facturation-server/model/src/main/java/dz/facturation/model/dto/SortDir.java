package dz.facturation.model.dto;

/**
 * sort enum
 */
public enum SortDir {
    DESC("desc"), ASC("asc");
    private String sort;

    SortDir(String sort) {
        this.sort = sort;
    }
}
