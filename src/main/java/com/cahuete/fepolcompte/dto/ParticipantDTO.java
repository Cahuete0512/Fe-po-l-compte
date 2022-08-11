package com.cahuete.fepolcompte.dto;

import com.cahuete.fepolcompte.entities.Participant;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ParticipantDTO {
    private Long id;
    private String email;
    private String surname;
    private String forename;
    private String mdp;

    public ParticipantDTO(Participant participant){
        this.id = participant.getId();
        this.email = participant.getEmail();
        this.surname = participant.getNom();
        this.forename = participant.getPrenom();
        this.mdp = participant.getMdp();
    }
}