package com.takami.rest.Service;

import com.takami.rest.model.Product;
import com.takami.rest.model.Rod;
import com.takami.rest.repositories.RodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RodServiceImpl implements RodService {
    @Autowired
    public RodServiceImpl(RodRepository rodRepository) {
        this.rodRepository = rodRepository;
    }

    private final RodRepository rodRepository;

    @Override
    public Optional<Rod> findRodById(Long id) {

        return rodRepository.findById(id);
    }

    @Override
    public List<Rod> findAllRods() {
        return rodRepository.findAll();
    }

    @Override
    public Long addNewRod(Rod rod) {
        rodRepository.save(rod);
        return rod.getId();
    }
}
