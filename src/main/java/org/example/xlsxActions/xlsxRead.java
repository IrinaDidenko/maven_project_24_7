package org.example.xlsxActions;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.models.Student;
import org.example.models.University;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xlsxRead {
    private xlsxRead() {
    }//приватный конструктор

    //метод чтения студентов
    public static List<Student> getStudents(String filePath) throws FileNotFoundException, IOException {
        List<Student> stuList = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheet("Студенты");

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row currentRow = rows.next();
            Student student = new Student();
            stuList.add(student);
            student.setUniversityId(currentRow.getCell(0).getStringCellValue());
            student.setFullName(currentRow.getCell(1).getStringCellValue());
            student.setCurrentCourseNumber((int)currentRow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentRow.getCell(3).getNumericCellValue());
        }
            return stuList;
        }


    //метод чтения университетов
    public static List<University> getUnivercities(String filePath) throws FileNotFoundException, IOException {
        Sheet sheet1;
        ArrayList<University> unilist = new ArrayList<University>();
        try (
                Workbook wb = WorkbookFactory.create(new File(filePath))) {
            DataFormatter formatter = new DataFormatter();
            sheet1 = wb.getSheetAt(1);
            for (int i = 1; i < sheet1.getLastRowNum() + 1; i++) {  //ignore header of the list
                Row row = sheet1.getRow(i);

                String id = formatter.formatCellValue(row.getCell(0));
                String fullName = formatter.formatCellValue(row.getCell(1));
                String shortName = formatter.formatCellValue(row.getCell(2));
                int yearOfFoundation = (int) Float.parseFloat(formatter.formatCellValue(row.getCell(3)));
                StudyProfile mainProfile = StudyProfile.valueOf(formatter.formatCellValue(row.getCell(4)));
                University e = new University(id, fullName, shortName, yearOfFoundation, mainProfile);
                unilist.add(e);
            }
            return unilist;
        }
    }

}
