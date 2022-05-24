package com.diplom.sstufinder.repository;

import com.diplom.sstufinder.SstuFinderApplication;
import com.diplom.sstufinder.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static final Logger logger = LoggerFactory.getLogger(SstuFinderApplication.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM \"user_student\"", BeanPropertyRowMapper.newInstance(UserModel.class));
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        logger.info(userModel.getFirstname(), userModel.getLastname());
        jdbcTemplate.update("INSERT INTO \"user_student\" (login, password, firstname, lastname, email, number_record_book) VALUES (?, ?, ?, ?, ?, ?)",
                                                            userModel.getLogin(),
                                                            userModel.getPassword(),
                                                            userModel.getFirstname(),
                                                            userModel.getLastname(),
                                                            userModel.getEmail(),
                                                            userModel.getNumber_record_book());
        return jdbcTemplate.queryForObject("SELECT * FROM \"user_student\" WHERE login = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userModel.getLogin());
    }

    @Override
    public UserModel getById(Long userId) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"user_student\" WHERE id = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userId);
    }

    @Override
    public UserModel getByLogin(String userLogin) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"user_student\" WHERE login = ?", BeanPropertyRowMapper.newInstance(UserModel.class), userLogin);
    }
}
