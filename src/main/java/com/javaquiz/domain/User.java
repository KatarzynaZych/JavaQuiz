package com.javaquiz.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "USERS")
public class User {

    private int id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;

    public User(int id,String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    @Id
    @Column(name = "USER_ID", unique = true)
    @NotNull
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @Column(name = "DATE_OF_BIRTH")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
