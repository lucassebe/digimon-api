package com.example.digimonapi.digimon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigimonService {
    @Autowired
    private DigimonRepository repository;
    public Digimon createDigimonFromRequest(DigimonRequestDTO digimonRequest){
        return new Digimon(null, digimonRequest.name(), digimonRequest.stage(), digimonRequest.img());
    }
    public DigimonResponseDTO insertDigimon(DigimonRequestDTO digimonRequest){
        List<Digimon> digimonList = repository.findByNameContainingIgnoreCase(digimonRequest.name());
        if(digimonList.isEmpty()) {
            Digimon digimon = new Digimon(null, digimonRequest.name(), digimonRequest.stage(), digimonRequest.img());
            Digimon savedDigimon = repository.save(digimon);
            return new DigimonResponseDTO(savedDigimon);
        }
        else{
            throw new IllegalArgumentException("More than one Digimon found with name containing: " + digimonRequest.name());
        }
    }
    public void deleteDigimonByName(String name) {
        List<Digimon> digimonList = repository.findByNameContainingIgnoreCase(name);
        if (!digimonList.isEmpty()) {
            if (digimonList.size() == 1) {
                repository.delete(digimonList.get(0));
            } else {
                throw new IllegalArgumentException("More than one Digimon found with name containing: " + name);
            }
        } else {
            throw new IllegalArgumentException("No Digimon found with name containing: " + name);
        }
    }
    public void updateDigimon(Long id, DigimonRequestDTO digimonRequest){
        List<Digimon> digimonList = repository.findDigimonById(id);
        if(digimonList.size() == 1) {
            Digimon existingDigimon = digimonList.get(0);
            existingDigimon.setName(digimonRequest.name());
            existingDigimon.setStage(digimonRequest.stage());

            repository.save(existingDigimon);
        } else {
            throw new IllegalArgumentException("Digimon not found with id: " + id);

        }

    }
}
