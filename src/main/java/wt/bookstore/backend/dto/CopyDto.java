package wt.bookstore.backend.dto;

import java.util.List;

public class CopyDto {
    private boolean available;

    private long bookId;

    private List<Long> loanIds;

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

    public List<Long> getLoanIds() {
        return loanIds;
    }

    public void setLoanIds(List<Long> loanIds) {
        this.loanIds = loanIds;
    }
}
