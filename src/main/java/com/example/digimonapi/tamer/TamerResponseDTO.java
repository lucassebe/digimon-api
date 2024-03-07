package com.example.digimonapi.tamer;

public record TamerResponseDTO(Long id, String tamer, Integer age, String digimon_partner, String digimon_series) {
    public TamerResponseDTO(Tamer tamer){
        this(tamer.getId(), tamer.getTamer(), tamer.getAge(), tamer.getDigimon_partner(), tamer.getDigimon_series());
    }
}
