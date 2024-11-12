package org.example.utility;

import org.example.models.DataStructure;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class JsonWriter {
    private static final Logger log = Logger.getLogger(JsonWriter.class.getName());

    public  JsonWriter(){};
    public static void generateJson(DataStructure ds){
        log.log(Level.INFO, "JSON writing started");

        try {
            Files.createDirectory(Path.of("JsonReqs"));
        } catch (IOException e) {
            log.log(INFO, " Directory is already exist ");
        }  log.log(INFO, "New directory created successfully ");

studentsJson(ds );
universityJson(ds);
statisticsJson(ds);
        log.log(Level.INFO, "JSON writing finished successfully");

    }

    public static void studentsJson(DataStructure ds){
     String stuListJson = JsonUtil.ListToJson(ds.getStudentList());
     try{
         FileOutputStream outputStream=new FileOutputStream("jsonReqs/students" + ds.getProcessedDate().getTime() + ".json");
         outputStream.write(stuListJson.getBytes(StandardCharsets.UTF_8));
     } catch (IOException e ) {
         log.log(SEVERE, "Student JSON writing failed", e);
     } log.log(INFO, "Student JSON created successfully");
    }

    public static void universityJson(DataStructure ds){
        String uniListJson = JsonUtil.ListToJson(ds.getUniversityList());
        try{
            FileOutputStream outputStream=new FileOutputStream("jsonReqs/universities" + ds.getProcessedDate().getTime() + ".json");
            outputStream.write(uniListJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e ) {
            log.log(SEVERE, "University JSON writing failed", e);
        } log.log(INFO, "University JSON created successfully");
    }

    public static void statisticsJson(DataStructure ds){
        String statisticsJson = JsonUtil.ListToJson(ds.getStatisticsList());
        try{
            FileOutputStream outputStream=new FileOutputStream("jsonReqs/statistics" + ds.getProcessedDate().getTime() + ".json");
            outputStream.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e ) {
            log.log(SEVERE, "Statistics JSON writing failed", e);
        } log.log(INFO, "Statistics JSON created successfully");
    }
}
