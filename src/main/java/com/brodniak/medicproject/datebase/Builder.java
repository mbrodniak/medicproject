package com.brodniak.medicproject.datebase;

import com.brodniak.medicproject.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Builder {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "Kolega66." );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void buildDoctorDB() throws SQLException {
        List<Doctor> doctorList = Reader.readFromFile();
        SqlUtil.createDoctorDB();
        SqlUtil.fillDoctorDB(connection,doctorList);
    }




}
