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

    //localdatetime
    @Column(name = "time_spending", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timeSpending;

    @Column(name = "publication_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date publicationTime;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentModel studentModel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private TeacherModel teacherModel;

}
