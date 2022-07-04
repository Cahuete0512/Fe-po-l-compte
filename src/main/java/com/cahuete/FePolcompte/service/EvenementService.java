package com.cahuete.FePolcompte.service;

import com.cahuete.FePolcompte.dto.EventDTO;
import com.cahuete.FePolcompte.dto.ParticipantDTO;
import com.cahuete.FePolcompte.dto.ResumedEvent;
import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.repository.EvenementRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvenementService {

    private final EvenementRepo evenementRepo;

    public EvenementService(EvenementRepo evenementRepo) {
        this.evenementRepo = evenementRepo;
    }

    public Evenement getEvenement(Long id){
        return evenementRepo.findEvenementById(id);
    }

    public EventDTO createEvenement(EventDTO eventDTO) {
        Evenement evenement = new Evenement(eventDTO);
        eventDTO = new EventDTO(evenementRepo.save(evenement));
        return eventDTO;
    }

    public EventDTO findById(Long id) {
        return evenementRepo.findById(id)
                .map(EventDTO::new)
                .orElse(null);
    }

    public List<ResumedEvent> getAll() {
        return evenementRepo.findAll().stream()
                .map(ResumedEvent::new)
                .collect(Collectors.toList());
    }

    public List<ParticipantDTO> getParticipantsByEvenementId(Long id) {
        Optional<Evenement> eventOpt = evenementRepo.findById(id);
        return eventOpt.map(evenement ->
                        evenement.getParticipantList().stream()
                                .map(ParticipantDTO::new)
                                .collect(Collectors.toList()))
                .orElseGet(ArrayList::new);
    }

    public void delete(Long id) {
        evenementRepo.deleteById(id);
    }

    public EventDTO modify(EventDTO eventDTO) {
        return new EventDTO(evenementRepo.save(new Evenement(eventDTO)));
    }
}
