package com.cahuete.FePolcompte.service;

import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.repository.EvenementRepo;

public class EvenementService {

    private final EvenementRepo evenementRepo;


    public EvenementService(EvenementRepo evenementRepo) {
        this.evenementRepo = evenementRepo;
    }

    public Evenement getEvenement(Long id){
        return evenementRepo.findEvenementById(id);
    }
}
