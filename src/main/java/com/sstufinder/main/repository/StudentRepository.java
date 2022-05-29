package com.sstufinder.main.repository;

import com.sstufinder.main.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    StudentModel findByLogin(String login);

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    boolean existsByRecordBookNumber(String recordBookNumber);

    @Query("select stud from StudentModel stud where stud.id = ?1")
    StudentInfo findById(long id);

    StudentModel findAllById(long id);
}
