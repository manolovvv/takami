package com.takami.rest.repositories;

import com.takami.rest.model.Rod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodRepository extends JpaRepository<Rod, Long> {
}
