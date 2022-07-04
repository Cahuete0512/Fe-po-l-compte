package com.cahuete.FePolcompte.repository;

import com.cahuete.FePolcompte.dto.ParticipantDTO;
import com.cahuete.FePolcompte.entities.Evenement;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepo extends CrudRepository<Evenement, Long>, JpaSpecificationExecutor<Evenement> {

    @Override
    List<Evenement> findAll();

    Evenement findEvenementById(Long id);
}
