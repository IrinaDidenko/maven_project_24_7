package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.models.Student;
import org.example.models.University;
import org.example.readerxlsx.xlsxRead;
import org.example.utility.ComparatorUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    private static String filePath = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {

        List<University> universities =
                xlsxRead.getUnivercities(filePath);

        UniversityComparator universityComparator= ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream().sorted(universityComparator).forEach(System.out::println);

        List<Student> students =
                xlsxRead.getStudents(filePath);
        for (Student student : students) {
            System.out.println(student);
        }

        StudentComparator studentComparator= ComparatorUtil.getStudentComparator(StudentComparatorType.FULL_NAME);
        students.stream().sorted(studentComparator).forEach(System.out::println);
    }
}
