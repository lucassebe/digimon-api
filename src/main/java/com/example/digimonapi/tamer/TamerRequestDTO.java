package com.example.digimonapi.tamer;

import jakarta.validation.constraints.NotEmpty;

public record TamerRequestDTO(Long id, @NotEmpty(message = "The field Tamer cannot be empty!")String tamer,
                              Integer age, String digimonPartner, String digimonSeries) {}
