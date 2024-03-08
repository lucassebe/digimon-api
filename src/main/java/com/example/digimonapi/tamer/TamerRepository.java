package com.example.digimonapi.tamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TamerRepository extends JpaRepository<Tamer, Long> {
    List<Tamer> findTamerByTamerContainingIgnoreCase(String tamer);

    List<Tamer> findTamerById(Long id);

    @Query("SELECT t FROM digimon_tamer t WHERE t.tamer = ?1")
    List<Tamer> findTamerByName(String tamer);
}
