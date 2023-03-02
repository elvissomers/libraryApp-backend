package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private long bookId;
	private long userId;
	private String date;


	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
