package com.example.MagicalLibraryy.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Userid;
    @NotEmpty
    @Column(nullable = false) private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid.email}")
    private String email;
    @NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "Userid")},
    inverseJoinColumns = { @JoinColumn (name = "ROLE_ID", referencedColumnName = "id")})
    private List<Role> roles;

    public User( ) {

    }

    public User(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }
}
