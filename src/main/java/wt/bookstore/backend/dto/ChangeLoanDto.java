package wt.bookstore.backend.dto;

import java.time.LocalDate;

public class ChangeLoanDto {

    private LocalDate endDate;


    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
