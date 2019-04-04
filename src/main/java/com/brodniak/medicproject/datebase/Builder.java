package com.brodniak.medicproject.datebase;

import com.brodniak.medicproject.model.Doctor;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Builder {
    private static Connection connection;
    private static Logger log = Logger.getLogger(Builder.class.getName());


    public static void buildDoctorDB() throws SQLException {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root", "Kolega66." );
            List<Doctor> doctorList = Reader.readFromFile();
            SqlUtil.createDoctorDB(connection);
            SqlUtil.fillDoctorDB(connection, doctorList);
            SqlUtil.createAppointmentDB(connection);
            SqlUtil.createEventDB(connection);
            SqlUtil.createPatientDB(connection);
        }
        catch (SQLException e){
            log.error(e.getMessage());
        }
        finally {
            if(!connection.isClosed()){
                connection.close();
            }
        }
    }




}
