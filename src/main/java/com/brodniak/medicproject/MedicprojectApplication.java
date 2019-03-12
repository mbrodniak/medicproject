package com.brodniak.medicproject;

import com.brodniak.medicproject.datebase.Builder;
import com.brodniak.medicproject.datebase.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class MedicprojectApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(MedicprojectApplication.class, args);

        Builder.buildDoctorDB();
    }

}
