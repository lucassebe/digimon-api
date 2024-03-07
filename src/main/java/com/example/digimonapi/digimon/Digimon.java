package com.example.digimonapi.digimon;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "digimon")
@Entity(name = "digimon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Digimon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stage;
    private String img;

    //Caso queira armazenar direto no objeto
//
//    public Digimon(DigimonRequestDTO data) {
//        this.name = data.name();
//        this.stage = data.stage();
//        this.img = data.img();
//    }
}