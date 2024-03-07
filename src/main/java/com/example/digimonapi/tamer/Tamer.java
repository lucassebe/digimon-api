package com.example.digimonapi.tamer;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "digimon_tamer")
@Entity(name = "digimon_tamer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tamer {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String tamer;
        private Integer age;
        private String digimon_partner;
        private String digimon_series;


}
