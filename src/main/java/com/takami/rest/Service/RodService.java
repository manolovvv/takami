package com.takami.rest.Service;

import com.takami.rest.model.Rod;

import java.util.List;
import java.util.Optional;

public interface RodService {
    Optional<Rod> findRodById(Long id);
    List<Rod> findAllRods();
    Long addNewRod(Rod rod);
}
