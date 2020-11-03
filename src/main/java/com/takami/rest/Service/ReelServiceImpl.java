package com.takami.rest.Service;

import com.takami.rest.model.Reel;
import com.takami.rest.repositories.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReelServiceImpl implements ReelService {

    @Autowired
    public ReelServiceImpl(ReelRepository reelRepository) {
        this.reelRepository = reelRepository;
    }
    private final ReelRepository reelRepository;

    @Override
    public Optional<Reel> findReelById(Long id) {
        return reelRepository.findById(id);
    }

    @Override
    public List<Reel> findAll() {
        return reelRepository.findAll();
    }

    @Override
    public Long addNewReel(Reel reel) {
        reelRepository.save(reel);
        return reel.getId();
    }
}
