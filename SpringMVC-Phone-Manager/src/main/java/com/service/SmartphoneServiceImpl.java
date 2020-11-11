package com.service;

import com.model.Smartphone;
import com.repository.SmartphoneRepository;
import com.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;

public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Long id) {
        Smartphone smartphone = smartphoneRepository.findById(id).orElse(null);
        if(smartphone == null){
            return null;
        }
        return smartphone;
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Long id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.deleteById(id);
        return smartphone;
    }
}
