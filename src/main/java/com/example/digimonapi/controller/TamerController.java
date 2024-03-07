package com.example.digimonapi.controller;

import com.example.digimonapi.digimon.DigimonResponseDTO;
import com.example.digimonapi.tamer.TamerRepository;
import com.example.digimonapi.tamer.TamerResponseDTO;
import com.example.digimonapi.tamer.TamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("tamer")
public class TamerController {
    @Autowired
    private TamerRepository repository;
    @Autowired
    private TamerService service;

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        List<TamerResponseDTO> tamersList = repository.findAll().stream()
                .map(TamerResponseDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tamersList, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Object> getTamer(@RequestParam String tamer){
        List<TamerResponseDTO> tamersList = repository.findTamerByTamerContainingIgnoreCase(tamer).stream()
                .map(TamerResponseDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tamersList, HttpStatus.OK);

    }

}
