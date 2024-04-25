package com.example.talentsourcingsystem.request;

import com.example.talentsourcingsystem.entity.CandidateInteraction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class CandidateCreateRequest {
    private String name;
    private String surname;
    private String contactInformation;
    private List<CandidateInteraction> previousInteractions = new ArrayList<>();
    private String candidateStatus;
}
