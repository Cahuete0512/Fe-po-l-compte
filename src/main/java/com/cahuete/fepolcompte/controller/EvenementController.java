package com.cahuete.fepolcompte.controller;

import com.cahuete.fepolcompte.dto.EventDTO;
import com.cahuete.fepolcompte.dto.ParticipantDTO;
import com.cahuete.fepolcompte.dto.ResumedEvent;
import com.cahuete.fepolcompte.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (originPatterns = "*")
@RestController
public class EvenementController {

    private final EvenementService evenementService;

    /**
     *
     * @param evenementService
     */
    @Autowired
    public EvenementController(EvenementService evenementService) {
        this.evenementService = evenementService;
    }

    /**
     *
     * @return tous les évenements
     */
    @CrossOrigin (originPatterns = "*")
    @GetMapping("/evenement")
    public List<ResumedEvent> getEvenements(){
        return evenementService.getAll();
    }

    /**
     * Récupération d'un évenement grâce à son id
     * @param id identifiant de l'évenement
     * @return un évenement précis
     */
    @GetMapping("/evenement/{id}")
    public EventDTO getEvenement(@PathVariable(name = "id") Long id) {
        return evenementService.findById(id);
    }

    /**
     * Récupération de la liste des participants pour un évènement précis
     * @param id
     * @return les participants d'un évènement précise
     */
    @CrossOrigin (originPatterns = "*")
    @GetMapping("/evenement/{id}/participants")
    public List<ParticipantDTO> getParticipantsByEvenement(@PathVariable(name = "id") Long id){
        return evenementService.getParticipantsByEvenementId(id);
    }

    /**
     * Insertion d'un évenement
     * @param eventDTO
     * @return
     */
    @PostMapping("/evenement/create")
    public EventDTO creatEvent(@RequestBody EventDTO eventDTO){
        return evenementService.createEvenement(eventDTO);
    }

    /**
     * Modification d'un évenement
     * @param eventDTO
     */
    @CrossOrigin (originPatterns = "*")
    @PutMapping(value = "/evenement/")
    public EventDTO modifyEvent(@RequestBody EventDTO eventDTO){
        return evenementService.modify(eventDTO);
    }

    /**
     * Suppression d'un évenement
     * @param id
     */
    @DeleteMapping("/evenement/suppEvenement/{id}")
    public void supprimerEvenement(@PathVariable Long id){
        evenementService.delete(id);
    }
}
