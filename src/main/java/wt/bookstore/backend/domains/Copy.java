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
	private long userId;
	private long bookId;
	
	public Copy() {
		
	}
	
	public Copy(boolean available, long userId, long bookId) {
		this.available = available;
		this.userId = userId;
		this.bookId = bookId;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
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
