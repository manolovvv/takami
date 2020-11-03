package com.takami.rest.Service;

import com.takami.rest.model.Hook;
import com.takami.rest.repositories.HookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HookServiceImpl implements HookService {

    public final HookRepository hookRepository;

    @Autowired
    public HookServiceImpl(HookRepository hookRepository) {
        this.hookRepository = hookRepository;
    }

    @Override
    public Hook findById(Long id) {
        return hookRepository.findById(id).get();
    }

    @Override
    public List<Hook> findAllHooks() {
        return hookRepository.findAll();
    }

    @Override
    public void addNewHook(Hook hook) {
        hookRepository.save(hook);

    }

    @Override
    public void deleteHook(Long id) {
         hookRepository.delete(findById(id));
    }


}
