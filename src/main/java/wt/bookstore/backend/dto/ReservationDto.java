package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Reservation} class that is sent to the frontend. The
 * fields in this class contain the information of a reservation object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class ReservationDto {

    private long id;

    private LocalDate date;

    private String userFirstName;

    private String userLastName;

    private String bookTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
