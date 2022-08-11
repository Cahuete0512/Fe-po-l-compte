package com.cahuete.fepolcompte.repository;

import com.cahuete.fepolcompte.entities.Participant;
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