package com.cahuete.FePolcompte.service;

import com.cahuete.FePolcompte.entities.Participant;
import com.cahuete.FePolcompte.repository.ParticipantsRepo;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    private final ParticipantsRepo participantsRepo;

    public ParticipantService(ParticipantsRepo participantsRepo) {
        this.participantsRepo = participantsRepo;
    }

    public Participant getParticipants(Long id){
        return participantsRepo.findParticipantById(id);
    }
}
