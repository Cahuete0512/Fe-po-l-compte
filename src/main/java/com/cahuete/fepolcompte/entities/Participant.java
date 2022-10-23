package com.cahuete.fepolcompte.entities;

import com.cahuete.fepolcompte.dto.ParticipantDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    @ManyToMany(mappedBy = "participantList")
    private List<Evenement> evenementList = new ArrayList<>();

    @OneToMany(mappedBy = "crediteur")
    private List<Paiement> paiementList = new ArrayList<>();

    @OneToMany(mappedBy = "beneficiaire")
    private List<Remboursement> remboursementList = new ArrayList<>();

    public Participant(ParticipantDTO participantDTO){
        this.id = participantDTO.getId();
        this.email = participantDTO.getEmail();
        this.nom = participantDTO.getForename();
        this.prenom = participantDTO.getSurname();
        this.mdp = participantDTO.getMdp();
    }
}
