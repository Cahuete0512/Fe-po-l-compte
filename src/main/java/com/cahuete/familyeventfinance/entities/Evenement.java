package com.cahuete.familyeventfinance.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Evenement {

    private int id;
    private String libelle;
    private LocalDate date;
    private String lieu;
    private List<Participant> participants;
}
