package com.brodniak.medicproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.SQLException;

@SpringBootApplication
public class MedicprojectApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(MedicprojectApplication.class, args);

//        Builder.buildDoctorDB();
    }

}
