package com.example.talentsourcingsystem.service;

import com.example.talentsourcingsystem.entity.Candidate;
import com.example.talentsourcingsystem.exception.CandidateNotFoundException;
import com.example.talentsourcingsystem.repository.CandidateRepository;
import com.example.talentsourcingsystem.request.CandidateCreateRequest;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    private CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates=candidateRepository.findAll();
        if(candidates.isEmpty()){
            throw new CandidateNotFoundException("There are no candidates.");
        }
        else{
            return candidates;
        }
    }
    

    public Candidate createCandidate(CandidateCreateRequest candidateCreateRequest) {
        Candidate newCandidate=new Candidate();
        newCandidate.setName(candidateCreateRequest.getName());
        newCandidate.setSurname(candidateCreateRequest.getSurname());
        newCandidate.setContactInformation(candidateCreateRequest.getContactInformation());
        newCandidate.setPreviousInteractions(candidateCreateRequest.getPreviousInteractions());
        newCandidate.setCandidateStatus(candidateCreateRequest.getCandidateStatus());
        return candidateRepository.save(newCandidate);

    }

    public Candidate updateCandidate(Long candidateId, Candidate newCandidate) {
        Optional<Candidate> candidate=candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            Candidate foundCandidate=candidate.get();
            foundCandidate.setName(newCandidate.getName());
            foundCandidate.setSurname(newCandidate.getSurname());
            foundCandidate.setContactInformation(newCandidate.getContactInformation());
            foundCandidate.setPreviousInteractions(newCandidate.getPreviousInteractions());
            foundCandidate.setCandidateStatus(newCandidate.getCandidateStatus());
            candidateRepository.save(foundCandidate);
            return foundCandidate;
        }
        else{
            throw new CandidateNotFoundException("Candidate with id: "+ candidateId+ " is not found.");
        }
    }
    public void deleteById(Long candidateId) {
        Optional<Candidate> candidate=candidateRepository.findById(candidateId);
        if(candidate.isPresent()){
            candidateRepository.deleteById(candidateId);
        }
        else{
            throw new CandidateNotFoundException("Candidate with id: "+ candidateId+ " is not found.");
        }

    }

    public Optional<Candidate> getOneCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId);
    }
}
