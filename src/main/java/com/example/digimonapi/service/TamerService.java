package com.example.digimonapi.service;

import com.example.digimonapi.tamer.TamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TamerService {
    @Autowired
    private TamerRepository repository;
    
}
