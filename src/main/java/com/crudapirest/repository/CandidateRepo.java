package com.crudapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crudapirest.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

}
