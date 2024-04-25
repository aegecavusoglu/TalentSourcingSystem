package com.example.talentsourcingsystem.request;

import com.example.talentsourcingsystem.entity.Candidate;

import lombok.Data;

import java.util.Date;

@Data

public class InteractionCreateRequest {
    private String type;
    private String content;
    private Date date;
    private boolean candidateResponded;
    private Long candidateId;


}
