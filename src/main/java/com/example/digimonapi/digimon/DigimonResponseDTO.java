package com.example.digimonapi.digimon;

public record DigimonResponseDTO(Long id, String name, String stage, String img) {
    public DigimonResponseDTO(Digimon digimon){
    this(digimon.getId(), digimon.getName(), digimon.getStage(), digimon.getImg());
    }
}
