package codesquad.user;

/**
 * Created by Geon Hee Sung.
 * Date: 2019-04-05
 * Time: 오후 12:04
 */
public class User {
    private String userId;
    private String password;
    private String name;
    private String email;

    public User() {
    }

    public boolean isSameUserId(String userId) {
        return this.userId.equals(userId);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
