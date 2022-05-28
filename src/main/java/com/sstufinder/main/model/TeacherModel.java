package com.sstufinder.main.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "teacher")
public class TeacherModel {
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

}
