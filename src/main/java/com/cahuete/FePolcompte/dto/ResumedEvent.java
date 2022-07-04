package com.cahuete.FePolcompte.dto;

import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.entities.Paiement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class ResumedEvent {
    private Long eventId ;
    private String name ;
    private int participantNumber;
    private LocalDate date;
    private String place;
    private float total;

    public ResumedEvent(Evenement evenement){
       this.eventId = evenement.getId();
       this.name = evenement.getLibelle();
       this.participantNumber = evenement.getParticipantList().size();
       this.date = evenement.getDate_creation();
       this.place = evenement.getLieu();
       this.total = evenement.getPaiementList().stream()
               .map(Paiement::getMontant)
               .reduce(0f, Float::sum);
    }
}


