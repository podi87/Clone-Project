package com.clone.repository;


import com.clone.model.FunnelEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunnelEventRepository extends CrudRepository<FunnelEvent, Long> {
}
