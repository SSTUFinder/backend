package com.diplom.sstufinder.repository;

import com.diplom.sstufinder.model.UserModel;

import java.util.List;

public interface UserRepository {

    UserModel getById(Long userId);
    UserModel getByLogin(String userLogin);

    List<UserModel> findAll();

    UserModel createUser(UserModel userModel);



}
