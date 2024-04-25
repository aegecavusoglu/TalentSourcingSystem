package com.example.talentsourcingsystem.repository;

import com.example.talentsourcingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

}
