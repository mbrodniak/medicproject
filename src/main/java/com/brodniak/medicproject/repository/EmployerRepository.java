package com.brodniak.medicproject.repository;

import com.brodniak.medicproject.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    Employer findByLogin(String login);

}
