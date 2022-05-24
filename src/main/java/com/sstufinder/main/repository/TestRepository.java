package com.sstufinder.main.repository;

import com.sstufinder.main.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {

    @Query("select t from TestModel t where t.firstname= ?1")
    List<TestModel> findByFirstname(String firstname);
}
