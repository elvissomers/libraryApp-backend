package wt.bookstore.backend.dto;

public class SaveCopyDto {
    private boolean available;

    private long bookId;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
