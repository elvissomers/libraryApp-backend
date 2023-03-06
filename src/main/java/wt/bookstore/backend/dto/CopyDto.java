package wt.bookstore.backend.dto;

import java.util.List;

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
