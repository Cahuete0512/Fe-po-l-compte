package com.cahuete.FePolcompte.controller;

import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.entities.Participant;
import com.cahuete.FePolcompte.repository.EvenementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin (originPatterns = "*")
@RestController
public class EvenementController {

    private final EvenementRepo evenementRepo;

    /**
     *
     * @param evenementRepo
     */
    @Autowired
    public EvenementController(EvenementRepo evenementRepo) {

        this.evenementRepo = evenementRepo;
    }

    /**
     *
     * @return tous les évenements
     */
    @CrossOrigin (originPatterns = "*")
    @GetMapping("/evenement")
    public Iterable<Evenement> getEvenements(){

        return evenementRepo.findAll();
    }

    /**
     * Récupération d'un évenement grâce à son id
     * @param id identifiant de l'évenement
     * @return un évenement précis
     */
    @GetMapping("/evenement/{id}")
    public Optional<Evenement> getEvenement(@PathVariable Long id) {
        return evenementRepo.findById(id);
    }

    @GetMapping("/evenement/{id}/participants")
    public List<Participant> getParticipantsByEvenement(@PathVariable Long id){
        Evenement evenement = new Evenement();
        Optional<Evenement> evenementOpt = evenementRepo.findById(id);
        if(evenementOpt.isPresent()){
            evenement = evenementOpt.get();
        }
        return evenement.getParticipants();
    }

    /**
     * Insertion d'un évenement
     * @param evenement
     */
    @PostMapping("/evenement")
    public Evenement creerEvenement(@RequestBody Evenement evenement){

        return evenementRepo.save(evenement);
    }

    /**
     * Modification d'un évenement
     * @param evenement
     * @param id
     */
    @CrossOrigin (originPatterns = "*")
    @PutMapping("/evenement/{id}")
    public Evenement modifierEvenement(@RequestBody Evenement evenement, @PathVariable Long id){
        evenement.setId(id);
        return evenementRepo.save(evenement);
    }

    /**
     * Suppression d'un évenement
     * @param id
     */
    @DeleteMapping("/evenement/suppEvenement/{id}")
    public void supprimerEvenement(@PathVariable Long id){
        evenementRepo.deleteById(id);
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
