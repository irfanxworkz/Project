package com.xworkz.parking.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.parking.dto.ExcelDataDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelUploadService {
	
			private static double getDoubleValue(Cell cell) {
		        if (cell.getCellType() == CellType.NUMERIC) {
		            return (double) cell.getNumericCellValue();
		        } else {
		            return 0.0; // Handle other cell types as needed
		        }
		    }
			private static int getIntValue(Cell cell) {
			        if (cell.getCellType() == CellType.NUMERIC) {
			            return (int) cell.getNumericCellValue();
			        } else {
			            return 0; // Handle other cell types as needed
			        }
			    }
			 
			public static List<ExcelDataDTO> getDataFromExcel(InputStream inputStream) {
		        log.info("Running getDataFromExcel() method in Util class " + inputStream);
		        List<ExcelDataDTO> list = new ArrayList<>();
		        try {
		            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		            XSSFSheet sheet = workbook.getSheetAt(0);
		            log.info("sheet value  : " + sheet);
		            if (sheet != null) {
		                int rowIndex = 0;
		                for (Row row : sheet) {
		                    if (rowIndex == 0) {
		                        rowIndex++;
		                        continue;
		                    }
		                    Iterator<Cell> cellIterator = row.iterator();
		                    int cellIndex = 0;
		                    ExcelDataDTO dto = new ExcelDataDTO();
		                    
		                    while (cellIterator.hasNext()) {
		                        Cell cell = cellIterator.next();
		                        log.info("cell value : " + cell);
		                    switch (cellIndex) {
		                        case 0 : 
		                        		 dto.setLocation(cell.getStringCellValue());
		                        case 1 : 
		                        		 dto.setType(cell.getStringCellValue());
		                        case 2 : 
		                        		 dto.setClassification(cell.getStringCellValue());
		                        case 3 :
		                            	 dto.setTerms(getIntValue(cell));
		                            	 // dto.setTerms((int) cell.getNumericCellValue());
		                        case 4 :
		                            	 dto.setPrice(getDoubleValue(cell));
		                            	 // dto.setPrice((double)cell.getNumericCellValue());
		                        case 5 :
		                        		 dto.setDiscount(getIntValue(cell));
		                        		 // dto.setDiscount((int) cell.getNumericCellValue());
		                        default :
		                                  log.info("default case ..................");
		                    }
		                        cellIndex++;
		                    }
		                    list.add(dto);
		                }
		                return list;
		            } else {
		                log.error("Excel sheet not found.");
		            }
		        } catch (IOException e) {
		            log.error("Error reading Excel file", e);
		        }
		        return list;
		}
	}