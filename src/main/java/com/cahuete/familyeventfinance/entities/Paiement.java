package com.cahuete.familyeventfinance.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Paiement {
    private Long id;
    private float montant;
    private String libelle;
    private List<Participant> participants;
    private Evenement evenement;

    public Paiement() {
    }
}

