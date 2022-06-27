package com.cahuete.familyeventfinance.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Participant {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private List<Evenement> evenement;

    public Participant(){
    }

}
