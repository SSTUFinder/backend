package com.diplom.sstufinder.repository;

import com.diplom.sstufinder.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class EventRepositoryImpl implements EventRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<EventModel> getAll() {
        return jdbcTemplate.query("SELECT * FROM \"events\"", BeanPropertyRowMapper.newInstance(EventModel.class));
    }

    @Override
    public List<EventModel> getByDate(java.sql.Date eventDate) {
        return jdbcTemplate.query("SELECT * FROM \"events\" WHERE date = ?", BeanPropertyRowMapper.newInstance(EventModel.class), eventDate);
    }
}
