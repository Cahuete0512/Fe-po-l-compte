package com.cahuete.FePolcompte.controller;

import com.cahuete.FePolcompte.dto.EventDTO;
import com.cahuete.FePolcompte.dto.ParticipantDTO;
import com.cahuete.FePolcompte.dto.ResumedEvent;
import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.repository.EvenementRepo;
import com.cahuete.FePolcompte.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @PutMapping("/evenement")
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
//
//    @GetMapping("/insert")
//    public String insert(@RequestParam String nom, @RequestParam(required = false) String dateString){
//        if(dateString == null){
//            dateString = "2020-12-10";
//        }
//
//        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
//        LocalDate date = LocalDate.parse(dateString, df);
//        Evenement evenement=new Evenement(nom, date);
//        evenementRepo.save(evenement);
//        return String.format("Evenement %s enregistré le %s", nom, date);
//    }
//
//    @GetMapping("/show")
//    public String select(){
//        List<Evenement> evenementList = (List<Evenement>) evenementRepo.findAll();
//        return evenementList.stream().map(Evenement::getAffichage).collect(Collectors.joining(";"));
//    }
}
