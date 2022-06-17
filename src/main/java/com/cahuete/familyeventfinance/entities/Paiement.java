package com.cahuete.familyeventfinance.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Paiement {
    private int id;
    private float montant;
    private List<Participant> participants;
    private Evenement evenement;
}
