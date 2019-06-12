package com.brodniak.medicproject.repository;

import com.brodniak.medicproject.entity.Appointment;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Transient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {


    List<Appointment> findAll();

//    @Query(value = "select * from appointment where date_ = ?1" ,nativeQuery = true)
//    List<Appointment> findByDate(Date date);

    List<Appointment> findByDateBetweenAndDoctorId(Timestamp start, Timestamp end, int id);

    List<Appointment> findByDateBefore(Date date);


    Appointment save(Appointment appointment);

}
