package com.cahuete.fepolcompte.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Remboursement extends Reglement{


    @ManyToOne
    private Participant beneficiaire;
}
