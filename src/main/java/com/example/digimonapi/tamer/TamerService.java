package com.example.digimonapi.tamer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TamerService {
    @Autowired
    private TamerRepository repository;
    
}
