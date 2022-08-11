package com.cahuete.fepolcompte.dto;

import com.cahuete.fepolcompte.entities.Evenement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class EventDTO {
    private Long id;
    private LocalDate date;
    private String name;
    private String place;

    private List<ParticipantDTO> participants = new ArrayList<>();
    private List<PayementDTO> payements = new ArrayList<>();

    public EventDTO(Evenement evenement){
        this.id = evenement.getId();
        this.date = evenement.getDate_creation();
        this.name = evenement.getLibelle();
        this.place = evenement.getLieu();
        this.participants = evenement.getParticipantList().stream()
                .map(ParticipantDTO::new)
                .collect(Collectors.toList());
        this.payements = evenement.getPaiementList().stream()
                .map(PayementDTO::new)
                .collect(Collectors.toList());
    }
}
