package com.cahuete.FePolcompte.dto;

import com.cahuete.FePolcompte.entities.Evenement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class EventDTO {
    private Long id;
    private LocalDate date;
    private String name;
    private String place;

    private List<ParticipantDTO> participantDTOList;
    private List<PayementDTO> payementDTOList;

    public EventDTO(Evenement evenement){
        this.id = evenement.getId();
        this.date = evenement.getDate_creation();
        this.name = evenement.getLibelle();
        this.place = evenement.getLieu();
        this.participantDTOList = evenement.getParticipantList().stream()
                .map(ParticipantDTO::new)
                .collect(Collectors.toList());
        this.payementDTOList = evenement.getPaiementList().stream()
                .map(PayementDTO::new)
                .collect(Collectors.toList());
    }
}
