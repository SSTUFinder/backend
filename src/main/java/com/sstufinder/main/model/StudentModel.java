package com.sstufinder.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "student")
public class StudentModel {

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

    @OneToMany(mappedBy = "studentModel", cascade = CascadeType.ALL)
    private List<EventModel> eventModels;

}
