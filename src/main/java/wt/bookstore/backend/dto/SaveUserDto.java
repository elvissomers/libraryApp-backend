package wt.bookstore.backend.dto;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.User} class that is sent from the frontend to the
 * backend. The fields in this class should contain the information needed to create a user object.
 */
public class SaveUserDto {

    private String name;

    private String eMailAddress;

    private boolean admin;

    /*
     * Ik denk dat de loan list en reservation list hier niet inhoeft, aangezien
     * loans en reservations alleen kunnen worden aangemaakt op een al bestaande user
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
