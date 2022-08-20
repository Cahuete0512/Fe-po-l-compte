package com.cahuete.fepolcompte.controller;

import com.cahuete.fepolcompte.dto.ParticipantDTO;
import com.cahuete.fepolcompte.entities.Participant;
import com.cahuete.fepolcompte.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Participant> create(@RequestBody @Valid Participant participant) {
        Participant savedParticipant = participantService.save(participant);
        URI participantURI = URI.create("/participant" + savedParticipant.getId());
        return ResponseEntity.created(participantURI).body(savedParticipant);
    }
}
