package com.cahuete.fepolcompte.entities;


import com.cahuete.fepolcompte.dto.EventDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * mon super evenement (ce commentaire est lié à la javadoc d'exemple de la méthode calculerRemboursement())
 */
@Getter
@Setter
@Entity
@Table(name="evenement")
@AllArgsConstructor
@NoArgsConstructor
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private LocalDate date_creation;
    private String lieu;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "participant_evenement",
            joinColumns = { @JoinColumn(name = "ID_EVENEMENT") },
            inverseJoinColumns = { @JoinColumn(name = "ID_PARTICIPANT")
            }
    )
    private List<Participant> participantList = new ArrayList<>();

    @OneToMany(mappedBy = "evenement")
    private List<Paiement> paiementList = new ArrayList<>();

    public Evenement(EventDTO eventDTO) {
        this.id = eventDTO.getId();
        this.libelle = eventDTO.getName();
        this.date_creation = eventDTO.getDate();
        this.lieu= eventDTO.getPlace();
        this.participantList = eventDTO.getParticipants().stream()
                .map(Participant::new)
                .collect(Collectors
                        .toList()
                );
    }
}
