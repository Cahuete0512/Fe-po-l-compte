package com.cahuete.FePolcompte.repository;

import com.cahuete.FePolcompte.dto.ParticipantDTO;
import com.cahuete.FePolcompte.entities.Evenement;
import com.cahuete.FePolcompte.entities.Participant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantsRepo extends CrudRepository<Participant, Long>, JpaSpecificationExecutor<Participant> {

    @Override
    List<Participant> findAll();

    Participant findParticipantById(Long id);
}