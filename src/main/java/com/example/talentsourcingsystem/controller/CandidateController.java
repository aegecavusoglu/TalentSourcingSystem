package com.example.talentsourcingsystem.controller;


import com.example.talentsourcingsystem.entity.Candidate;
import com.example.talentsourcingsystem.request.CandidateCreateRequest;
import com.example.talentsourcingsystem.service.CandidateService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/candidate")
@CrossOrigin("http://localhost:8081/")
public class CandidateController {
    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public List<Candidate> getAllCandidates(){
        return candidateService.getAllCandidates();
    }
    @GetMapping("/{candidateId}")
    public Optional<Candidate> getOneCandidate(@PathVariable Long candidateId){
        return candidateService.getOneCandidateById(candidateId);
    }

    @PostMapping("/create")
    public Candidate createCandidate(@RequestBody CandidateCreateRequest candidateCreateRequest){
        return candidateService.createCandidate(candidateCreateRequest);
    }
    @PutMapping("/update/{candidateId}")
    public Candidate updateCandidate(@PathVariable Long candidateId,@RequestBody Candidate newCandidate){
        return candidateService.updateCandidate(candidateId,newCandidate);
    }
    @DeleteMapping("/delete/{candidateId}")
    public void deleteById(@PathVariable Long candidateId){
        candidateService.deleteById(candidateId);
    }


}
