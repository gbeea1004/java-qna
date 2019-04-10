package codesquad.user;

import javax.persistence.*;

/**
 * Created by Geon Hee Sung.
 * Date: 2019-04-05
 * Time: 오후 12:04
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    private String email;

    public User() {
    }

    public boolean isSameUserId(String userId) {
        return this.userId.equals(userId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void update(User updateUser) {
        this.name = updateUser.name;
        this.password = updateUser.password;
        this.email = updateUser.email;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
