package com.takami.rest.Service;

import com.takami.rest.model.Hook;

import java.util.List;

public interface HookService {
    Hook findById(Long id);
    List<Hook> findAllHooks();
    void addNewHook(Hook hook);
    void deleteHook(Long id);

}
