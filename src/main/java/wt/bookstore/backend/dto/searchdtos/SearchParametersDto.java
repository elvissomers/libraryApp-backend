package wt.bookstore.backend.dto.searchdtos;

public class SearchParametersDto {

    private String searchTerm;

    private String propertyToSortBy;

    private String directionOfSort;

    private int pageNumber;

    private int numberPerPage;

    private boolean open;

    private boolean archived;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getPropertyToSortBy() {
        return propertyToSortBy;
    }

    public void setPropertyToSortBy(String propertyToSortBy) {
        this.propertyToSortBy = propertyToSortBy;
    }

    public String getDirectionOfSort() {
        return directionOfSort;
    }

    public void setDirectionOfSort(String directionOfSort) {
        this.directionOfSort = directionOfSort;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getNumberPerPage() {
        return numberPerPage;
    }

    public void setNumberPerPage(int numberPerPage) {
        this.numberPerPage = numberPerPage;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
