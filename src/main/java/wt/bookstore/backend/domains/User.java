package wt.bookstore.backend.domains;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private String name;
	private String eMailAddress;
	private boolean admin;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Loan> loans;

	@OneToMany(mappedBy = "user", orphanRemoval = true)
	private List<Reservation> reservations;

	public User(String name, String eMailAddress, boolean admin) {
		this.name = name;
		this.eMailAddress = eMailAddress;
		this.admin = admin;
	}

	public User() {

	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMailAddress() {
		return eMailAddress;
	}

	public void seteMailAddress(String eMailAdress) {
		this.eMailAddress = eMailAdress;
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

}
