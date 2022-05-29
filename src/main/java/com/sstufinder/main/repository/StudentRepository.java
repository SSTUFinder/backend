package com.sstufinder.main.repository;

import com.sstufinder.main.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

    StudentModel findByLogin(String login);

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
    boolean existsByRecordBookNumber(String recordBookNumber);

    @Query("select s from StudentModel s where s.id = ?1")
    StudentInfo findById(long id);

    StudentModel findAllById(long id);

//    @Transactional
    @Modifying
    @Query("update StudentModel s set s.reason = :reason where s.id = :id")
//    @Query(value ="update StudentModel set reason = :reason where StudentModel.id = <:id", nativeQuery = true)
    void updateStudentReasonById(@Param("id")long id, @Param("reason") String reason);

}
