package com.example.digimonapi.tamer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TamerRepository extends JpaRepository<Tamer, Long> {

    List<Tamer> findTamerByTamerContainingIgnoreCase(String tamer);

}
