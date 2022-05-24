package com.sstufinder.main.service;

import com.sstufinder.main.model.TestModel;
import com.sstufinder.main.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Override
    public List<TestModel> findByFirstname(String firstname) {
        return testRepository.findByFirstname(firstname);
    }
}
