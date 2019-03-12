package com.brodniak.medicproject.datebase;

import com.brodniak.medicproject.Doctor;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;

public class SqlUtil {
    private static Logger log = Logger.getLogger(SqlUtil.class.getName());
    private static Connection connection;
    private static Statement statement;


    public static void createDoctorDB()  {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "Kolega66." );
            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS doctor" +
                    "(ID INTEGER NOT NULL, " +
                    "first_name VARCHAR(255), " +
                    "last_name VARCHAR(255), " +
                    "spec VARCHAR(255)," +
                    "PRIMARY KEY (ID))";
            statement.execute(sql);
        }
        catch (SQLException e){
            log.error(e.getMessage());
        }

    }
    public static void fillDoctorDB(Connection connection, List<Doctor> doctorList){
        try{

            String sql = "INSERT INTO doctor VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for(Doctor doctor : doctorList){
                preparedStatement.setInt(1,doctor.getId());
                preparedStatement.setString(2,doctor.getFirstName());
                preparedStatement.setString(3,doctor.getLastName());
                preparedStatement.setString(4,"null");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
        catch (SQLException e){
            log.error(e.getMessage());
        }



    }


}
