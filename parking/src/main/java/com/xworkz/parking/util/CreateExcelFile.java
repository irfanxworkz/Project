package com.xworkz.parking.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateExcelFile {

    public static void main(String[] args) {
        // Specify the absolute path for the output file
        String filePath = "C:\\Users\\irfan khan\\OneDrive\\Desktop\\x-workz\\CreateExcelFileThrow\\parking.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            // Creating a header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("location");
            headerRow.createCell(1).setCellValue("type");
            headerRow.createCell(2).setCellValue("classification");
            headerRow.createCell(3).setCellValue("terms");
            headerRow.createCell(4).setCellValue("price");
            headerRow.createCell(5).setCellValue("discount");

            // Creating data rows
            Row dataRow = sheet.createRow(1);
            dataRow.createCell(0).setCellValue("Rajaji-Nagar");
            dataRow.createCell(1).setCellValue("4-Wheeler");
            dataRow.createCell(2).setCellValue("Audi");
            dataRow.createCell(3).setCellValue("45-days");
            dataRow.createCell(4).setCellValue(2520);
            dataRow.createCell(5).setCellValue(10);

            // Writing to an Excel file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                System.out.println("fileout :"+fileOut);
            }

            System.out.println("Excel file created successfully at: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}