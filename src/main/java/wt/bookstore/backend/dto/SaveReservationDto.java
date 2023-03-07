package wt.bookstore.backend.dto;

import java.time.LocalDate;

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
