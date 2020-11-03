package com.takami.rest.Controllers;

import com.takami.rest.Service.RodService;
import com.takami.rest.model.Product;
import com.takami.rest.model.Rod;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(RodController.BASE_URL)
public class RodController {

    public static final String BASE_URL = "/rods";
    private final RodService rodService;

    public RodController(RodService rodService) {
        this.rodService = rodService;

    }

    @GetMapping
    List<Rod> getAllRods(){
        return rodService.findAllRods();
    }

    @GetMapping("/{id}")
    Optional<Rod> getRodById(@PathVariable Long id){
        return rodService.findRodById(id);
    }

    @PostMapping
    Long addNewRod(@RequestBody Rod rod){
        return rodService.addNewRod(rod);
    }

}
