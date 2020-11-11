package com.service;


import com.model.Smartphone;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone phone);
    Smartphone remove(Long id);
}
