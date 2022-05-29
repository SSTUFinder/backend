package com.sstufinder.main.repository;

import com.sstufinder.main.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventModel, Long> {

    @Query("select event from EventModel event")
    List<SimpleEvent> findAllEventWithName();

    EventModel save(EventModel eventModel);

//    @Query("select event.id, event.place, event.publicationTime, event.timeSpending from EventModel event")
//    List<EventModel> findAll();

}
