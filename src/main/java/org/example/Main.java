package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utility.StatisticsUtil;
import org.example.xlsxActions.xlsxRead;
import org.example.utility.ComparatorUtil;
import org.example.xlsxActions.xlsxWrite;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static String filePath = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws Exception {


        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        /*Universities operations*/
        List<University> universities =
                xlsxRead.getUnivercities(filePath);

        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);

/*Students operations*/
        List<Student> students =
                xlsxRead.getStudents(filePath);

        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.FULL_NAME);

        List<Statistics>statisticsList= StatisticsUtil.formStatistics(students, universities);
        xlsxWrite.writeXlsx("statistics.xlsx", statisticsList);
        logger.log(INFO, "Application finished its work. Job is done");
    }
}
