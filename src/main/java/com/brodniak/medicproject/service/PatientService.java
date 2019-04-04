package com.brodniak.medicproject.service;

import com.brodniak.medicproject.dto.PatientDTO;
import com.brodniak.medicproject.entity.Patient;
import org.springframework.stereotype.Service;


@Service
public class PatientService {

    public Patient patientRegistration(PatientDTO patientDTO) {

        try{
            Patient patient = new Patient(patientDTO);
            System.out.println("Odebrany patient to: " + patientDTO.toString());
            patient.setFirstName(patientDTO.getFirstName());
            patient.setLastName(patientDTO.getLastName());
            patient.setBirthDate(patientDTO.getBirthDate());
            patient.setAbility(patientDTO.isAbility());
            patient.setEmail(patientDTO.getEmail());
            patient.setPassword(patientDTO.getPassword());
            return patient;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new Patient();
        }

    }

}
