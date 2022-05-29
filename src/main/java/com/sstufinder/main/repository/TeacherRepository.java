package com.sstufinder.main.repository;

import com.sstufinder.main.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {

    TeacherModel findByLogin(String login);

    boolean existsByEmail(String email);
    boolean existsByLogin(String login);

    @Query("select teacher from TeacherModel teacher where teacher.id = ?1")
    TeacherInfo findById(long id);

    TeacherModel findAllById(long id);
}
