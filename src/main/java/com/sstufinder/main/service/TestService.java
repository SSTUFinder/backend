package com.sstufinder.main.service;

import com.sstufinder.main.model.TestModel;

import java.util.List;

public interface TestService {
    List<TestModel> findByFirstname(String firstname);
}
