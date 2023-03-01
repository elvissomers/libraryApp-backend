package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Copy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private boolean available;
	private long heldByUserId;
	private long bookId;

	public Copy() {

	}

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
