package wt.bookstore.backend.dto;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Copy} class that is sent from the frontend to the
 * backend. The fields in this class should contain the information needed to create a copy object.
 */
public class SaveCopyDto {

    private long bookId;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
