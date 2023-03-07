package wt.bookstore.backend.dto;

import java.time.LocalDate;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.Reservation} class that is sent from the frontend to the
 * backend. The fields in this class should contain the information needed to create a reservation object.
 */
public class SaveReservationDto {

    private LocalDate date;

    private long userId;

    private long bookId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }


}
