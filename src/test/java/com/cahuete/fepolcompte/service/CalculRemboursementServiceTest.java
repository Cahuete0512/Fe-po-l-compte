package com.cahuete.fepolcompte.service;

import com.cahuete.fepolcompte.dto.EventDTO;
import com.cahuete.fepolcompte.dto.ParticipantDTO;
import com.cahuete.fepolcompte.entities.Evenement;
import com.cahuete.fepolcompte.entities.Paiement;
import com.cahuete.fepolcompte.entities.Participant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculRemboursementServiceTest {

    public CalculRemboursementService calculRemboursementService = new CalculRemboursementService();

    @Test
    void calculerRemboursementTest(){
        //GIVEN
        Evenement event = new Evenement();
        event.setParticipantList(new ArrayList<>());
        Participant participant1 = new Participant();

        List<Paiement> paiementList = new ArrayList<>();
        Paiement paiement1 = new Paiement();
        paiement1.setMontant(99f);
        paiement1.setCrediteur(participant1);
        paiement1.setEvenement(event);
        event.setPaiementList(new ArrayList<>());
        event.getPaiementList().add(paiement1);
        paiementList.add(paiement1);

        participant1.setPaiementList(paiementList);
        event.getParticipantList().add(participant1);
        Participant participant2 = new Participant();
        event.getParticipantList().add(participant2);
        Participant participant3 = new Participant();
        event.getParticipantList().add(participant3);


        //WHEN
        calculRemboursementService.calculerRemboursement(event);

        //THEN
        assertThat(event.getParticipantList().get(0).getRemboursementList()).isEmpty();
        assertThat(event.getParticipantList().get(1).getRemboursementList()).hasSize(1);
        assertThat(event.getParticipantList().get(1).getRemboursementList().get(0).getMontant()).isEqualTo(33f);
        assertThat(event.getParticipantList().get(2).getRemboursementList()).hasSize(1);
        assertThat(event.getParticipantList().get(2).getRemboursementList().get(0).getMontant()).isEqualTo(33f);
        assertThat(event.getParticipantList().get(2).getRemboursementList().get(0).getMontant())
                .isEqualTo(event.getParticipantList().get(1).getRemboursementList().get(0).getMontant());

    }
}