package wt.bookstore.backend.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ID;
	private String name;
	private String eMailAdress;
	private boolean admin;

	public User(String name, String eMailAdress, boolean admin) {
		this.name = name;
		this.eMailAdress = eMailAdress;
		this.admin = admin;
	}

	public User() {

	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String geteMailAdress() {
		return eMailAdress;
	}

	public void seteMailAdress(String eMailAdress) {
		this.eMailAdress = eMailAdress;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



}
