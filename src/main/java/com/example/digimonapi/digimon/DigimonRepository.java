package com.example.digimonapi.digimon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DigimonRepository extends JpaRepository<Digimon,Long> {
    List<Digimon> findByNameContainingIgnoreCase(String name);
    List<Digimon> findDigimonById(Long id);

}
