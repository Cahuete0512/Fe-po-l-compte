package com.cahuete.fepolcompte.service;

import com.cahuete.fepolcompte.dto.ParticipantDTO;
import com.cahuete.fepolcompte.entities.Participant;
import com.cahuete.fepolcompte.repository.ParticipantsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    private final ParticipantsRepo participantsRepo;

    public ParticipantService(ParticipantsRepo participantsRepo) {
        this.participantsRepo = participantsRepo;
    }

    public Participant getParticipant(Long id){
        return participantsRepo.findParticipantById(id);
    }

    public List<ParticipantDTO> findAll() {
        return participantsRepo.findAll().stream()
                .map(ParticipantDTO::new)
                .collect(Collectors.toList());
    }

}
