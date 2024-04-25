package com.example.talentsourcingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "candidate")
public class Candidate {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="contact_information")
    private String contactInformation;
    @Column(name="candidate_status")
    private String candidateStatus;


    @OneToMany(mappedBy = "candidateId",cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"content","date","candidateResponded","candidateId"})
    private List<CandidateInteraction> previousInteractions = new ArrayList<>();

    public void addInteraction(CandidateInteraction candidateInteraction){
        previousInteractions.add(candidateInteraction);
        candidateInteraction.setCandidateId(this.id);
    }


}
