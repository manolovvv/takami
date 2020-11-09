package com.takami.rest.repositories;

import com.takami.rest.model.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepository extends JpaRepository<Reel, Long> {
}
