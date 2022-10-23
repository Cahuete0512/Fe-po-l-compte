package com.cahuete.fepolcompte.service;

import com.cahuete.fepolcompte.entities.Evenement;
import com.cahuete.fepolcompte.entities.Paiement;
import com.cahuete.fepolcompte.entities.Remboursement;
import org.springframework.stereotype.Service;


@Service
public class CalculRemboursementService {


    /**
     * <h1>Super méthode de calcul</h1>
     * <li>
     *     <ul>fait un truc</ul>
     *     <ul>un AUTRE truc ...</ul>
     * </li>
     * @param evenement le {@link Evenement}
     *                  <h3>Le link sert à lier la doc à la classe</h3>
     */
    public void calculerRemboursement(Evenement evenement){

        float montantTotal = 0;
        for(Paiement paiement:evenement.getPaiementList()){
            montantTotal += paiement.getMontant();
        }
        //TODO : calculer le montant de remboursement pour chaque participant en fonction de ce que ce participant a déjà payé
    }
}
