package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utility.StatisticsUnil;
import org.example.xlsxActions.xlsxRead;
import org.example.utility.ComparatorUtil;
import org.example.utility.JsonUtil;
import org.example.xlsxActions.xlsxWrite;

import java.io.IOException;
import java.util.List;

public class Main {
    private static String filePath = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws Exception {
        /*Universities operations*/
        List<University> universities =
                xlsxRead.getUnivercities(filePath);

        UniversityComparator universityComparator = ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream().sorted(universityComparator).forEach(System.out::println);
        String universitiesJson = JsonUtil.UniListSerialize(universities);
        System.out.println("Universisites list in JSON format: \n "+universitiesJson+"\n =========================================");
        List<University> unisFromJson = JsonUtil.UniListDeSerialize(universitiesJson);
        if (unisFromJson.size() == universities.size()) {
            System.out.println("Deserialize ended successfully");
        } else {
            System.out.println("Something went wrong. Deserialize ended unsuccessfully");
        }

        universities.forEach(university -> {
            String universityJson = JsonUtil.UniversitySerialize(university);
            System.out.println(universityJson);
            University uniFromJson = JsonUtil.UniversityDeSerialize(universityJson);
            System.out.println(uniFromJson.toString());
        });
/*Students operations*/
        List<Student> students =
                xlsxRead.getStudents(filePath);
        for (Student student : students) {
            System.out.println(student);
        }

        StudentComparator studentComparator = ComparatorUtil.getStudentComparator(StudentComparatorType.FULL_NAME);
        students.stream().sorted(studentComparator).forEach(System.out::println);

        String studentsJson = JsonUtil.StuListSerialize(students);
        System.out.println("Students list in JSON format: \n "+studentsJson+"\n =========================================");
        List<Student> stuFromJson = JsonUtil.StuListDeSerialize(studentsJson);
        if (stuFromJson.size() == students.size()) {
            System.out.println("Deserialize ended successfully");
        } else {
            System.out.println("Something went wrong. Deserialize ended unsuccessfully");
        }

        students.forEach(student -> {
            String studentJson = JsonUtil.StudentSerialize(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.StudentDeSerialize(studentJson);
            System.out.println(studentFromJson.toString());
        });

        List<Statistics>statisticsList= StatisticsUnil.formStatistics(students, universities);
        xlsxWrite.writeXlsx("statistics.xlsx", statisticsList);
    }
}
