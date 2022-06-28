package com.cahuete.FePolcompte.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;

    @ManyToMany
    private List<Evenement> evenementList;

    @OneToMany
    private List<Paiement> paiementList;
}
