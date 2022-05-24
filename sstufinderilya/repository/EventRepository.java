package com.diplom.sstufinder.repository;

import com.diplom.sstufinder.model.EventModel;

import java.util.Date;
import java.util.List;

public interface EventRepository {

    List<EventModel> getAll();

    List<EventModel> getByDate(java.sql.Date eventDate);
}
