package wt.bookstore.backend.dto;

public class SaveKeywordDto {

    private String name;

    /*
     * Ik weet niet zeker of dit de goede manier is om dit te doen
     */
    private long bookId;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getBookId() {
        return bookId;
    }
}