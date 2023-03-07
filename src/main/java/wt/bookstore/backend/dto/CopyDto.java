package wt.bookstore.backend.dto;

import java.util.List;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Copy} class that is sent to the frontend. The
 * fields in this class contain the information of a copy object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class CopyDto {
    private boolean available;

    private String bookTitle;


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
