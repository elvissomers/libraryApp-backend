package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Copy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private boolean available;
	private long heldByUserId;
	private long bookId;

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

    public long getHeldByUserId() {
        return heldByUserId;
    }

    public void setHeldByUserId(long heldByUserId) {
        this.heldByUserId = heldByUserId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
