package wt.bookstore.backend.dto;

public class LoginResponseDto {

    private String token;
    private boolean admin;

    private long userId;

    public LoginResponseDto(String token, boolean admin, long userId) {
        this.token = token;
        this.admin = admin;
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
