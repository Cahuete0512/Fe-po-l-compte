package com.cahuete.FePolcompte.repository;

import com.cahuete.FePolcompte.entities.Evenement;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EvenementRepo extends CrudRepository<Evenement, Long>, JpaSpecificationExecutor<Evenement> {

    Optional<Evenement> findAllById(Long id);

    Evenement findEvenementById(Long id);
}
