package com.cahuete.FePolcompte.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private LocalDate date_creation;
    private String lieu;

    public Evenement() {
        this.libelle = libelle;
        this.date_creation = date_creation;
        this.lieu = lieu;
    }
//    private List<Participant> participants;
}
