package com.takami.rest.repositories;

import com.takami.rest.model.Hook;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HookRepository extends JpaRepository<Hook,Long> {
}
