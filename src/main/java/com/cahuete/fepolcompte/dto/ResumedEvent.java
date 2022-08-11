package com.cahuete.fepolcompte.dto;

import com.cahuete.fepolcompte.entities.Evenement;
import com.cahuete.fepolcompte.entities.Paiement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ResumedEvent {
    private Long id;
    private String name ;
    private int participantNumber;
    private LocalDate date;
    private String place;
    private float total;

    public ResumedEvent(Evenement evenement){
       this.id = evenement.getId();
       this.name = evenement.getLibelle();
       this.participantNumber = evenement.getParticipantList().size();
       this.date = evenement.getDate_creation();
       this.place = evenement.getLieu();
       this.total = evenement.getPaiementList().stream()
               .map(Paiement::getMontant)
               .reduce(0f, Float::sum);
    }
}


