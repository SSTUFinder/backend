package com.sstufinder.main.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "event")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    //localdatetime
    @Column(name = "time_spending", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeSpending;

    @Column(name = "publication_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date publicationTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentModel studentModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacherModel;

}
