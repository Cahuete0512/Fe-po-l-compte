package com.cahuete.FePolcompte.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private LocalDate date_creation;
    private String lieu;

    @ManyToMany
    private List<Participant> participants;

    @OneToMany
    private List<Paiement> paiementList;

}
