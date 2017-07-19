package com.clone.repository;

import com.clone.model.Funnel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunnelRepository extends CrudRepository<Funnel, Long> {
}
