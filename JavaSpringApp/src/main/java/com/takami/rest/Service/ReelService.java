package com.takami.rest.Service;

import com.takami.rest.model.Reel;


import java.util.List;
import java.util.Optional;


public interface ReelService {
    public Optional<Reel> findReelById(Long id);
    public List<Reel> findAll();
    public Long addNewReel(Reel reel);
}
