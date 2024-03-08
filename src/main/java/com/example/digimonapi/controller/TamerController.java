package com.example.digimonapi.controller;

import com.example.digimonapi.service.TamerService;
import com.example.digimonapi.tamer.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tamer")
public class TamerController {
    @Autowired
    private TamerRepository repository;
    @Autowired
    private TamerService service;

    @GetMapping()
    public ResponseEntity<Object> getAll(Pageable pageable){
        Page<Tamer> tamersPage = repository.findAllByOrderByIdAsc(pageable);
        List<TamerResponseDTO> tamersList = tamersPage.getContent().stream()
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
    @PostMapping("/insert")
    public ResponseEntity<Object> insertTamer(@RequestBody TamerRequestDTO tamerRequest){
            TamerNewResponseDTO tamerNewResponseDTO = service.insertTamer(tamerRequest.tamer(), tamerRequest);
            return new ResponseEntity<>(tamerNewResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTamer(@PathVariable Long id, @RequestBody TamerRequestDTO tamerRequest){
        try {
            TamerNewResponseDTO tamerNewResponseDTO = service.updateTamer(id, tamerRequest);
            return new ResponseEntity<>(tamerNewResponseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
