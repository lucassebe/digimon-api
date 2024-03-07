package com.example.digimonapi.controller;

import com.example.digimonapi.digimon.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("digimon")
public class DigimonController {
    @Autowired
    private DigimonRepository repository;
    @Autowired
    private DigimonService service;

    @GetMapping()
    public ResponseEntity<Object> searchByName(@RequestParam(required = false) String name, @RequestParam(required = false) Long id) {
        if (name != null) {
            List<Digimon> digimonList = repository.findByNameContainingIgnoreCase(name);
            if (digimonList.isEmpty()) {
                return new ResponseEntity<>("Nenhum Digimon encontrado para o nome fornecido.", HttpStatus.NOT_FOUND);
            }
            List<DigimonResponseDTO> responseDTOList = digimonList.stream()
                    .map(DigimonResponseDTO::new)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
        } else if (id != null) {
            List<Digimon> digimonList = repository.findDigimonById(id);
            if (digimonList.isEmpty()) {
                return new ResponseEntity<>("Nenhum Digimon encontrado para o id fornecido.",HttpStatus.NOT_FOUND);
            }
            List<DigimonResponseDTO> responseDTOList = digimonList.stream()
                    .map(DigimonResponseDTO::new)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responseDTOList, HttpStatus.OK);
        } else {
            List<DigimonResponseDTO> digimonList = repository.findAll().stream()
                    .map(DigimonResponseDTO::new)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(digimonList, HttpStatus.OK);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Object> insertDigimon(@RequestBody DigimonRequestDTO digimonRequest) {
        try {
            DigimonResponseDTO responseDTO = service.insertDigimon(digimonRequest);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/insert/{name}")
    public ResponseEntity<Object>  deleteDigimon(@PathVariable String name) {
        try {
            service.deleteDigimonByName(name);
            return new ResponseEntity<>("Digimon was successfull deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateDigimon(@PathVariable Long id, @RequestBody DigimonRequestDTO digimonRequest){
        try {
            service.updateDigimon(id, digimonRequest);
            return new ResponseEntity<>(digimonRequest + "\nDigimon was successfull updated", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
