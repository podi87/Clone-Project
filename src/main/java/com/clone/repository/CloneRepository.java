package com.clone.repository;

import com.clone.model.Clone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloneRepository extends CrudRepository<Clone, Boolean> {

}
