package wt.bookstore.backend.dto;

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
