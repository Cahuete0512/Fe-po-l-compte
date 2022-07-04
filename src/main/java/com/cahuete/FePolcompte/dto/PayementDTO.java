package com.cahuete.FePolcompte.dto;

import com.cahuete.FePolcompte.entities.Paiement;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PayementDTO {
    private Long id;
    private String name;
    private Float payment;
    private Long eventId;
    private Long participantId;

    public PayementDTO(Paiement paiement){
        this.id = paiement.getId();
        this.name = paiement.getLibelle();
        this.payment = paiement.getMontant();
        this.eventId = paiement.getEvenement().getId();
        this.participantId = paiement.getParticipant().getId();
    }
}
