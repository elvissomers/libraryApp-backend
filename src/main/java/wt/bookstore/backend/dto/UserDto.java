package wt.bookstore.backend.dto;

/**
 * Data Transfer Object for the {@link wt.bookstore.backend.domains.User} class that is sent to the frontend. The
 * fields in this class contain the information of a user object that is deemed relevant to the user and are determined
 * by the needs of the frontend.
 */
public class UserDto {

    private long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private boolean admin;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
}
