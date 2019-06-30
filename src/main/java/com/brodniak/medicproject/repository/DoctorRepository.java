package com.brodniak.medicproject.repository;

import com.brodniak.medicproject.entity.Doctor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    List<Doctor> findAll();

    Doctor findByDoctorId(Integer id);

    List <Doctor> findBySpecialisation(String spec);
}
