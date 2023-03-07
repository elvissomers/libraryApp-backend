package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Reservation} class that is sent to the frontend. The
 * fields in this class contain the information of a reservation object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class ReservationDto {

    private LocalDate date;

    private String userName;

    private String bookTitle;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
