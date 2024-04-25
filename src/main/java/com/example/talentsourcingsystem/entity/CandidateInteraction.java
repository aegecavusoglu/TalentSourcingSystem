package com.example.talentsourcingsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Data
@Table(name = "candidate_interaction")
public class CandidateInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private Date date;
    @Column(name = "candidate_responded")
    private boolean candidateResponded;
    @Column(name="candidate_id")
    private Long candidateId;

}
