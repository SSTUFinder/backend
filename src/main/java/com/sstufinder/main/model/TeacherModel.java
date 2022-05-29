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
@Table(name = "teacher")
public class TeacherModel implements Serializable {
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

    public TeacherModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacherModels", cascade = CascadeType.ALL)
    private List<EventModel> eventModel;

}
