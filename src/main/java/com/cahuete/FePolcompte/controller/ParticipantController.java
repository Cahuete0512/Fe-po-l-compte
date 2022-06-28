package com.cahuete.FePolcompte.controller;

import com.cahuete.FePolcompte.entities.Participant;
import com.cahuete.FePolcompte.repository.ParticipantsRepo;
import com.cahuete.FePolcompte.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {

    private final ParticipantsRepo participantsRepo;
    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantsRepo participantsRepo,
                                 ParticipantService participantService) {
        this.participantsRepo = participantsRepo;
        this.participantService = participantService;
    }

    /**
     *
     * @return tous les participants
     */
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/participants")
    public Iterable<Participant> getParticipants(){
        return participantsRepo.findAll();
    }

    @GetMapping("/participant/{id}")
    public Participant getParticipantById(@PathVariable("id") Long id){
        return participantService.getParticipants(id);
    }
}
