package com.cahuete.FePolcompte.repository;

import com.cahuete.FePolcompte.entities.Participant;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantsRepo extends CrudRepository<Participant, Long>, JpaSpecificationExecutor<Participant> {
    Participant findParticipantById(Long id);
}