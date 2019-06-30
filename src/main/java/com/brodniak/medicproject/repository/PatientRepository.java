package com.brodniak.medicproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.brodniak.medicproject.entity.Patient;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


    List<Patient> findAll();

    @Override
    Patient save(Patient patient);

    @Query(value = "Select * from Patient  where email = ?1", nativeQuery = true)
    Patient findByEmail(String email);


    @Transactional
    @Modifying
    @Query(value = "Update Patient set ability = 1 where patient_id = ?1 ", nativeQuery = true)
    void changePatientAbility(int id);

    @Query(value = "select * from Patient where ability = 0", nativeQuery = true)
    ArrayList<Patient> getAllByAbility();

    Patient findById(int id);

}
