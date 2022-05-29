package com.sstufinder.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "student")
public class StudentModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public StudentModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentModels", cascade = CascadeType.ALL)
    private List<EventModel> eventModels;

    }
