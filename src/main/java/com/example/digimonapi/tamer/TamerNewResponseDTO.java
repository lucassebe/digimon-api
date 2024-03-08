package com.example.digimonapi.tamer;

public record TamerNewResponseDTO(String message, Tamer tamer) {
    public TamerNewResponseDTO(String message, Tamer tamer) {
        this.message = message;
        this.tamer = tamer;
    }
}