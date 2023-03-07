package wt.bookstore.backend.domains;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Reservation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private LocalDate date;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne(optional = false)
    private User user;


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
