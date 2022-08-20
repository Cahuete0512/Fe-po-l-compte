package com.cahuete.fepolcompte.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.cahuete.fepolcompte.entities.Participant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ParticipantsRepoTest {
    @Autowired private ParticipantsRepo participant;

    @Test
    public void testCreateUser() {
        // GIVEN
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String mdp = passwordEncoder.encode("nosf2022");

        Participant newParticipant = new Participant("nosf@codejava.net", mdp);
        newParticipant.setNom("Nosfe");
        newParticipant.setPrenom("Ratou");

//        WHEN
        Participant savedParticipant = participant.save(newParticipant);

//        THEN
        assertThat(savedParticipant).isNotNull();
        assertThat(savedParticipant.getId()).isGreaterThan(0);
        assertThat(savedParticipant.getNom()).isEqualTo("Nosfe");
        assertThat(savedParticipant.getPrenom()).isEqualTo("Ratou");
    }
}