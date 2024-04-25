package com.example.talentsourcingsystem.controller;
import com.example.talentsourcingsystem.entity.CandidateInteraction;
import com.example.talentsourcingsystem.request.InteractionCreateRequest;
import com.example.talentsourcingsystem.service.CandidateInteractionService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/candidateInteraction")
@CrossOrigin("http://localhost:8081/")

public class CandidateInteractionController {
    private CandidateInteractionService candidateInteractionService;

    public CandidateInteractionController(CandidateInteractionService candidateInteractionService) {
        this.candidateInteractionService = candidateInteractionService;
    }

    @GetMapping
    public List<CandidateInteraction> getAllInteractions(){
        return candidateInteractionService.getAllInteractions();
    }
    @PostMapping("/create/{candidateId}")
    public CandidateInteraction createInteraction(@PathVariable Long candidateId,@RequestBody InteractionCreateRequest interactionCreateRequest){
        return candidateInteractionService.createInteraction(candidateId,interactionCreateRequest);
    }

    @PutMapping("/update/{candidateInteractionId}")
    public CandidateInteraction UpdateInteraction(@PathVariable Long candidateInteractionId,@RequestBody CandidateInteraction newCandidateInteraction){
        return candidateInteractionService.updateInteraction(candidateInteractionId,newCandidateInteraction);

    }
    @DeleteMapping("/delete/{candidateId}")
    public void DeleteInteraction(@PathVariable Long candidateId){
        candidateInteractionService.deleteInteractionByCandidateId(candidateId);
    }

}
