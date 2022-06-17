package com.cahuete.familyeventfinance.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Participant {

    private int id;
    private String nom;
    private String prenom;
    private List<Evenement> evenement;

}
