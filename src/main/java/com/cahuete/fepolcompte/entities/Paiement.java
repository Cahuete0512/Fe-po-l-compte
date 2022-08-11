package com.cahuete.fepolcompte.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float montant;
    private String libelle;

    @ManyToOne
    private Participant participant;

    @ManyToOne
    private Evenement evenement;
}

