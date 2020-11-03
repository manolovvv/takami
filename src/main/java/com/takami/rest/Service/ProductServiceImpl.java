package com.takami.rest.Service;

import com.takami.rest.model.Hook;
import com.takami.rest.model.Product;
import com.takami.rest.model.Reel;
import com.takami.rest.model.Rod;
import com.takami.rest.repositories.HookRepository;
import com.takami.rest.repositories.ReelRepository;
import com.takami.rest.repositories.RodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductServiceImpl(HookRepository hookRepository, ReelRepository reelRepository, RodRepository rodRepository) {
        this.hookRepository = hookRepository;
        this.reelRepository = reelRepository;
        this.rodRepository = rodRepository;
    }


    public final HookRepository hookRepository;

    public final ReelRepository reelRepository;
    public final RodRepository rodRepository;

    public List<Product> findAllProducts(){
        List<Hook> hooks = hookRepository.findAll();
        List<Rod> rods = rodRepository.findAll();
        List<Reel> reels = reelRepository.findAll();
        List<Product> products = new ArrayList<>(hooks);
        products.addAll(rods);
        products.addAll(reels);
        return products;

    }

    @Override
    public Product findProductById(Long id) {
        Product product ;
      if(!hookRepository.findById(id).isEmpty()){
           product = hookRepository.findById(id).get();
            return product;
        }
        else if(!reelRepository.findById(id).isEmpty()){
            product = reelRepository.findById(id).get();
            return product;
        }
        else if(!rodRepository.findById(id).isEmpty()){
            product = rodRepository.findById(id).get();
            return product;
        }
        else{
            return null;
      }



    }



    @Override
    public Reel addNewReel(Reel reel) {
       reelRepository.save(reel);
       return reel;

     }

    @Override
    public Rod addNewRod(Rod rod) {
        rodRepository.save(rod);
        return rod;
    }

    @Override
    public Hook addNewHook(Hook hook) {
        hookRepository.save(hook);
        return hook;
    }

    @Override
    public boolean deleteProduct(Long id) {
        if(!rodRepository.findById(id).isEmpty()){
            rodRepository.deleteById(id);
            return true;
        }
        else if(!hookRepository.findById(id).isEmpty()){
            hookRepository.deleteById(id);
            return true;
        }
        else if(!reelRepository.findById(id).isEmpty()){
            reelRepository.deleteById(id);
            return true;
        }
        return false;

    }



}
