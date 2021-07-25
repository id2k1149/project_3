package org.id2k1149.project_3.models;

import javax.persistence.*;


@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private boolean admin;
    private String email;
    private String password;


    public User() {
    }

    public User(Long id,
                boolean admin,
                String email,
                String password
                   ) {
        this.id = id;
        this.admin = admin;
        this.email = email;
        this.password = password;
    }

    public User(boolean admin,
                String email,
                String password
                ) {
        this.admin = admin;
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", is admin='" + admin + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
