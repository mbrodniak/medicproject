package com.brodniak.medicproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brodniak.medicproject.entity.Patient;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


    List<Patient> findAll();
    @Override
    Patient save(Patient patient);

}
