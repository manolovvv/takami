package com.takami.rest.repositories;

import com.takami.rest.model.Hook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookRepository extends JpaRepository<Hook,Long> {
}
