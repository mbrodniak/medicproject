package com.brodniak.medicproject.datebase;

import com.brodniak.medicproject.Doctor;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Reader {

    private static Logger log = Logger.getLogger(Reader.class.getName());


    public static List<Doctor> readFromFile(){
        BasicConfigurator.configure();
        List<Doctor> doctorList = null;
        try{
            File file = new File("C:\\Users\\brodn\\Desktop\\folder\\tekst.txt");
            Scanner scanner = new Scanner(file);
            doctorList = new LinkedList<>();
            int i = 1;
            while(scanner.hasNextLine()){
                String[] s = scanner.nextLine().split(" ");
                doctorList.add(new Doctor(i, s[0], s[1], s[2]));
                i++;
                log.info("Doctor added to list");
            }

            log.info("DoctorList size: " + doctorList.size());
        }
        catch (IOException e){
            log.error(e.getMessage());
        }
        return doctorList;

    }



}
