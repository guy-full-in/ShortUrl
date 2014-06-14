package ru.kpfu.it.shorturl.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Ayrat on 23.04.2014.
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Size(min = 4, message = "Минимальный размер логина: 4")
    @Column(name = "username")
    private String username;

    @NotEmpty(message = "E-mail обязательное поле")
    @Email(message = "Такой e-mail не существует")
    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Size(min = 6, message = "Минимальный размер пароля: 6")
    @Column(name = "password")
    private String password;

    @JsonIgnore
    @Transient
    private String confirmPassword;

    @JsonIgnore
    @Column(name = "enabled")
    private boolean enabled = true;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "USER_UR",
            joinColumns = {@JoinColumn(name = "uur_user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "uur_ur_id", referencedColumnName = "user_role_id")})
    private List<UserRole> role;

    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Url> urls;


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getRole() {
        return role;
    }

    public void setRole(List<UserRole> role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
