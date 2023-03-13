package wt.bookstore.backend.dto;

public class ChangeCopyDto {

    private boolean available;

    private int number;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
