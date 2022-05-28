package com.sstufinder.main.repository;

import com.sstufinder.main.model.TeacherModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherModel, Long> {

    @Query("SELECT teacher FROM TeacherModel teacher WHERE teacher.login = ?1 and teacher.password = ?2 ")
    TeacherModel findByLoginPassword(@Param("login") String login, String password);
}
