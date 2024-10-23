package org.example.xlsxActions;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.models.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class xlsxWrite {
    private xlsxWrite() {
    }

    ;

    private static final Logger logger = Logger.getLogger(xlsxWrite.class.getName());
    //write xlsx method

    public static void writeXlsx(String fileName, List<Statistics> statisticsList) throws Exception {
        logger.log(Level.INFO, "Starting write xlsx file");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheetStatistics = workbook.createSheet("Statistics");
        //   XSSFRow row;
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        int row = 0;

//header row
        Row headerRow = spreadsheetStatistics.createRow(row++);

        Cell studyProfileHeader = headerRow.createCell(0);
        studyProfileHeader.setCellValue("профиль обучения");
        Cell avgScoreHeader = headerRow.createCell(1);
        avgScoreHeader.setCellValue("средний балл");
        Cell studentCountHeader = headerRow.createCell(2);
        studentCountHeader.setCellValue("количество студентов");
        Cell universityCountHeader = headerRow.createCell(3);
        universityCountHeader.setCellValue("количество университетов");
        Cell universityNamesHeader = headerRow.createCell(4);
        universityNamesHeader.setCellValue("университеты");

        studyProfileHeader.setCellStyle(headerStyle);
        avgScoreHeader.setCellStyle(headerStyle);
        studentCountHeader.setCellStyle(headerStyle);
        universityCountHeader.setCellStyle(headerStyle);
        universityNamesHeader.setCellStyle(headerStyle);

        //other rows
        for (Statistics statistics : statisticsList) {
            Row dataRow = spreadsheetStatistics.createRow(row++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getStudyProfile().getProfileName());
            Cell avgScore = dataRow.createCell(1);
            avgScore.setCellValue(statistics.getAvgScore());

            Cell studentCountCell = dataRow.createCell(2);
            studentCountCell.setCellValue(statistics.getStudentCount());
            Cell universityCountCell = dataRow.createCell(3);
            universityCountCell.setCellValue(statistics.getUniversityCount());
            Cell uniNamesCell = dataRow.createCell(4);
            uniNamesCell.setCellValue(statistics.getUniversityNames());

        }

        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        }catch (IOException e){
            logger.log(Level.SEVERE,"Failed to write data into xlsx file");
            return;
        }
        logger.log(Level.INFO,"Data has been written into xlsx file successfully");

    }
}
