package com.clone.repository;

import com.clone.model.EventToDatabase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventToDatabaseRepository extends CrudRepository<EventToDatabase, Long> {
}
