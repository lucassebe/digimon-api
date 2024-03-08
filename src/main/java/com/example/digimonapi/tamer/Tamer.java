package com.example.digimonapi.tamer;

import com.fasterxml.jackson.annotation.JsonProperty;
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
        @JsonProperty("digimon_partner")
        private String digimonPartner;
        @JsonProperty("digimon_series")
        private String digimonSeries;
}
