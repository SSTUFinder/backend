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

    @Column(name = "login",length = 50,unique = true, nullable = false)
    private String login;

    @Column(name = "firstname", length = 50,nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    private String email;

    @Column(name = "record_book_number", length = 8, unique = true, nullable = false)
    private String recordBookNumber;

    @Column(name = "reason")
    private String reason;

    @Column(name = "upgrade_tier", nullable = false)
    private boolean upgradeTier;

    @JsonIgnore
    @OneToMany(mappedBy = "studentModel", cascade = CascadeType.ALL)
    private List<EventModel> eventModels;
}
