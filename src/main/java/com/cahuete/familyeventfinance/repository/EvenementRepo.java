package com.cahuete.familyeventfinance.repository;

import com.cahuete.familyeventfinance.entities.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EvenementRepo extends CrudRepository<Evenement, Long> {

    void findByLibelle(String libelle);
}
