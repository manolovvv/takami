package com.takami.rest.Controllers;

import com.takami.rest.Service.ReelService;
import com.takami.rest.model.Reel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(ReelController.BASE_URL)
public class ReelController {

    public static final String BASE_URL = "/reels";
    private final ReelService reelService;

    public ReelController(ReelService reelService) {
        this.reelService = reelService;

    }

    @GetMapping
    List<Reel> getAllReels(){
        return reelService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Reel> getReelById(@PathVariable Long id){
        return reelService.findReelById(id);
    }

    @PostMapping
    Long addNewReel(@RequestBody Reel reel){
        return reelService.addNewReel(reel);
    }

}
