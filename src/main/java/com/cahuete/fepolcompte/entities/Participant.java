package com.cahuete.fepolcompte.entities;

import com.cahuete.fepolcompte.dto.ParticipantDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="participant")
public class Participant implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;

    @ManyToMany(mappedBy = "participantList")
    private List<Evenement> evenementList = new ArrayList<>();

    @OneToMany(mappedBy = "participant")
    private List<Paiement> paiementList = new ArrayList<>();

    public Participant(ParticipantDTO participantDTO){
        this.id = participantDTO.getId();
        this.email = participantDTO.getEmail();
        this.nom = participantDTO.getForename();
        this.prenom = participantDTO.getSurname();
        this.mdp = participantDTO.getMdp();
    }

    public Participant(String email, String mdp) {
        this.email=email;
        this.mdp = mdp;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.mdp;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
