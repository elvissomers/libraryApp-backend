package wt.bookstore.backend.domains;

public class Copy {
	private long ID;
	private boolean available;
	private User heldBy;
	private Book book;
	
	public Copy(boolean available, User heldBy, Book book) {
		this.available = available;
		this.heldBy = heldBy;
		this.book = book;
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

	public User getHeldBy() {
		return heldBy;
	}

	public void setHeldBy(User heldBy) {
		this.heldBy = heldBy;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
