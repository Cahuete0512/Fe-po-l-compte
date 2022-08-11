package com.cahuete.fepolcompte.controller;

import com.cahuete.fepolcompte.dto.ParticipantDTO;
import com.cahuete.fepolcompte.entities.Participant;
import com.cahuete.fepolcompte.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    /**
     *
     * @return tous les participants
     */
    @CrossOrigin(originPatterns = "*")
    @GetMapping("/participants")
    public List<ParticipantDTO> getParticipants(){
        return participantService.findAll();
    }

    @GetMapping("/participant/{id}")
    public Participant getParticipantById(@PathVariable("id") Long id){
        return participantService.getParticipant(id);
    }
}
