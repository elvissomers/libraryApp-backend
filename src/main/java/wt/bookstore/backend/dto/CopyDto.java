package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Copy} class that is sent to the frontend. The
 * fields in this class contain the information of a copy object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class CopyDto {

    private long id;

    private boolean available;

    private String bookTitle;

    private int number;

    private String heldByUserFirstName;

    private LocalDate heldSince;

    private boolean archived;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHeldByUserFirstName() {
        return heldByUserFirstName;
    }

    public void setHeldByUserFirstName(String heldByUserFirstName) {
        this.heldByUserFirstName = heldByUserFirstName;
    }

    public LocalDate getHeldSince() {
        return heldSince;
    }

    public void setHeldSince(LocalDate heldSince) {
        this.heldSince = heldSince;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

}
