package com.brodniak.medicproject.datebase;

import com.brodniak.medicproject.model.Doctor;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class SqlUtil {
    private static Logger log = Logger.getLogger(SqlUtil.class.getName());
    private static Connection connection;
    private static Statement statement;


    public static void createDoctorDB(Connection connection) {
        try {
//            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "Kolega66." );
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS doctor" +
                    "(doctor_id INTEGER NOT NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255), " +
                    "spec VARCHAR(255)," +
                    "PRIMARY KEY (doctor_id))";
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

    }

    public static void fillDoctorDB(Connection connection, List<Doctor> doctorList) {
        try {

            String sql = "INSERT INTO doctor VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Doctor doctor : doctorList) {
                preparedStatement.setInt(1, doctor.getDoctorId());
                preparedStatement.setString(2, doctor.getFirstName());
                preparedStatement.setString(3, doctor.getLastName());
                preparedStatement.setString(4, doctor.getSpecialisation());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            preparedStatement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

    }

    public static void createAppointmentDB(Connection connection) {

        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS appointment " +
                    "(appointment_id INTEGER NOT NULL, " +
                    "doctor_id INTEGER NOT NULL, " +
                    "start_date TIMESTAMP(0) NOT NULL, " +
                    "end_date TIMESTAMP(0) NOT NULL, " +
                    "event_id INTEGER NOT NULL, " +
                    "PRIMARY KEY (appointment_id), " +
                    "INDEX appointmentIndex (doctor_id, start_date, end_date));";
            statement.execute(sql);
//            String updateSql = "CREATE INDEX DOCTOR_INDEX ON appointment(DOCTOR_ID); CREATE INDEX START_DATE_INDEX ON appointment(start_date);";
//            String update = "CREATE INDEX START_DATE_INDEX ON appointment(start_date);";
//            statement.executeUpdate(updateSql);
//            statement.executeUpdate(update);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
    /*Insert into appoinmentDB*/

    public static void createEventDB(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS event " +
                    "(event_id INTEGER NOT NULL, " +
                    "description VARCHAR(255)," +
                    "patient_id INTEGER NOT NULL," +
                    "PRIMARY KEY (event_id));";
            statement.execute(sql);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /*Inser into eventDB*/

    public static void createPatientDB(Connection connection) {

        try {
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS patient " +
                    "(patient_id INTEGER NOT NULL, " +
                    "first_name VARCHAR(255) NOT NULL, " +
                    "last_name VARCHAR(255) NOT NULL, " +
                    "birth_date DATE NOT NULL, " +
                    "ability TINYINT(1), " +
                    "email VARCHAR (255) NOT NULL , " +
                    "password VARCHAR (255) NOT NULL, " +
                    "PRIMARY KEY (patient_id));";
            statement.execute(sql);

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }


}
