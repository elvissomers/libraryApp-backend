package wt.bookstore.backend.domains;

import java.util.List;

import jakarta.persistence.*;
import wt.bookstore.backend.validators.EmailConstraint;
import wt.bookstore.backend.validators.NameConstraint;

/**
 * The entity used for the users database
 */
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NameConstraint
	private String firstName;

	@NameConstraint
	private String lastName;

	@EmailConstraint
	private String emailAddress;

	@Column(nullable = false, length = 128)
	private String password;

	private String token;

	private boolean admin;

	@Column(columnDefinition = "boolean default false")
    private boolean archived;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Loan> loans;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Reservation> reservations;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Loan> getLoans() {
		return loans;
	}
	
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}
}
