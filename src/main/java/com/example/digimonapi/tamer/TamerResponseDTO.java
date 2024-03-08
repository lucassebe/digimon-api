package com.example.digimonapi.tamer;

public record TamerResponseDTO(Long id, String tamer, Integer age, String digimonPartner, String digimonSeries) {
    public TamerResponseDTO(Tamer tamer) {
        this(tamer.getId(), tamer.getTamer(), tamer.getAge(), tamer.getDigimonPartner(), tamer.getDigimonSeries());
    }
}

