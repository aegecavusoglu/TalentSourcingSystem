package com.example.talentsourcingsystem.service;
import com.example.talentsourcingsystem.entity.Candidate;
import com.example.talentsourcingsystem.entity.CandidateInteraction;
import com.example.talentsourcingsystem.exception.CandidateNotFoundException;
import com.example.talentsourcingsystem.repository.CandidateInteractionRepository;
import com.example.talentsourcingsystem.repository.CandidateRepository;
import com.example.talentsourcingsystem.request.InteractionCreateRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateInteractionService {
    CandidateInteractionRepository candidateInteractionRepository;
    CandidateRepository candidateRepository;

    public CandidateInteractionService(CandidateInteractionRepository candidateInteractionRepository, CandidateRepository candidateRepository) {
        this.candidateInteractionRepository = candidateInteractionRepository;
        this.candidateRepository = candidateRepository;
    }

    public List<CandidateInteraction> getAllInteractions() {
        return candidateInteractionRepository.findAll();
    }

    public CandidateInteraction updateInteraction(Long candidateInteractionId, CandidateInteraction newCandidateInteraction) {
        Optional<CandidateInteraction> candidateInteraction =candidateInteractionRepository.findById(candidateInteractionId);
        if(candidateInteraction.isPresent()){
            CandidateInteraction foundInteraction=candidateInteraction.get();
            foundInteraction.setType(newCandidateInteraction.getType());
            foundInteraction.setDate(newCandidateInteraction.getDate());
            foundInteraction.setCandidateResponded(newCandidateInteraction.isCandidateResponded());
            foundInteraction.setContent(newCandidateInteraction.getContent());
            candidateInteractionRepository.save(foundInteraction);
            return foundInteraction;
        }
        else{
            throw new CandidateNotFoundException("There is no interaction with this id.");
        }

    }
    @Transactional
    public void deleteInteractionByCandidateId(Long candidateId) {
        Optional<CandidateInteraction> candidateInteraction =candidateInteractionRepository.findCandidateInteractionByCandidateId(candidateId);
        if(candidateInteraction.isPresent()){
            candidateInteractionRepository.deleteByCandidateId(candidateId);
        }
        else{
            throw new CandidateNotFoundException("Candidate with id: "+ candidateId+ " is not found.");
        }
    }

    public CandidateInteraction createInteraction(@RequestParam Long candidateId,@RequestBody InteractionCreateRequest interactionCreateRequest) {
        Optional<Candidate> candidate=candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            Candidate candidate1=candidate.get();
            CandidateInteraction newCandidateInteraction=new CandidateInteraction();
            newCandidateInteraction.setType(interactionCreateRequest.getType());
            newCandidateInteraction.setContent(interactionCreateRequest.getContent());
            newCandidateInteraction.setDate(interactionCreateRequest.getDate());
            newCandidateInteraction.setCandidateResponded(interactionCreateRequest.isCandidateResponded());
            newCandidateInteraction.setCandidateId(interactionCreateRequest.getCandidateId());
            candidate1.addInteraction(newCandidateInteraction);
            return candidateInteractionRepository.save(newCandidateInteraction);
        }
        else{
            throw new CandidateNotFoundException("Candidate with id: "+ candidateId+" is not found.");
        }

    }
}
