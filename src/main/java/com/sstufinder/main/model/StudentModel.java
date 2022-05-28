package com.sstufinder.main.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentModel {

    @Id
    @GeneratedValue()
    @Column(name = "student_id")
    private long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "record_book_number", unique = true, nullable = false)
    private String recordBookNumber;

    @Column(name = "upgrade_tier", nullable = false)
    private boolean upgradeTier;

}
