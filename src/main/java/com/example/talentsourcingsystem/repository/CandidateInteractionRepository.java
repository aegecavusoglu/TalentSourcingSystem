package com.example.talentsourcingsystem.repository;

import com.example.talentsourcingsystem.entity.CandidateInteraction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateInteractionRepository extends JpaRepository<CandidateInteraction,Long> {
    Optional<CandidateInteraction> findCandidateInteractionByCandidateId(Long candidateId);

    void deleteByCandidateId(Long candidateId);
}
