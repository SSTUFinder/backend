package com.sstufinder.main.repository;

import com.sstufinder.main.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long> {

    @Query("select event, student.firstname, student.lastname, teacher.firstname, teacher.lastname  from EventModel event, StudentModel student, TeacherModel teacher")
    List<EventModel> findAll();

    List<EventModel> findAll

}
