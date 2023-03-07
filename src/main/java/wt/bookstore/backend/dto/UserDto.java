package wt.bookstore.backend.dto;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.User} class that is sent to the frontend. The
 * fields in this class contain the information of a user object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class UserDto {

    private String name;

    private String eMailAddress;

    private boolean admin;

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
