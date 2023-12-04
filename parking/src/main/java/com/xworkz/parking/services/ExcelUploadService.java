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
import com.xworkz.parking.dto.ParkingInfoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelUploadService {
	
			public static List<ParkingInfoDTO> getDataFromExcel(InputStream inputStream) {
		        log.info("Running getDataFromExcel() method in Util class " + inputStream);
		       List<ParkingInfoDTO> list = new ArrayList<>();
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
		                    ParkingInfoDTO dto = new ParkingInfoDTO();
		                    
		                    while (cellIterator.hasNext()) {
		                        Cell cell = cellIterator.next();
		                        log.info("cell value : " + cell);
		                    switch (cellIndex) {
			                    case 0 : 
				                    	if (cell.getCellType() == CellType.NUMERIC) {
				                        dto.setId((int) cell.getNumericCellValue());
				                    	} else {
				                    		log.error("Incorrect format for ID");
				                    		return null; // Return null for incorrect format
				                    	}
				                    break;
			                    case 1 :
			                    		if (cell.getCellType() == CellType.STRING) {
			                            dto.setLocation(cell.getStringCellValue());
			                    		} else {
			                    			log.error("Incorrect format for Location");
			                    			return null;
			                    		}
			                    	break;
		                        case 2 :
		                        		if (cell.getCellType() == CellType.STRING) {
		                        		dto.setType(cell.getStringCellValue());
		                        		} else {
		                        			log.error("Incorrect format for type");
				                           return null;
				                    	}
		                        		break;
		                        case 3 : 
		                        		if (cell.getCellType() == CellType.STRING) {
		                        		dto.setClassification(cell.getStringCellValue());
		                        		} else {
                    						log.error("Incorrect format for Classification");
                    						return null;
	                    				}
		                        	break;
		                        case 4 :
		                        		if (cell.getCellType() == CellType.STRING) {
		                            	dto.setTerms(cell.getStringCellValue());
		                        		} else {
                    						log.error("Incorrect format for terms");
                    						return null;
	                    				}
		                        	break;
		                        case 5 :
		                        		if (cell.getCellType() == CellType.NUMERIC) {
		                        		dto.setPrice((double)cell.getNumericCellValue());
		                        		} else {
		                        			log.error("Incorrect format for price");
		                        			return null;
		                        		}
		                        	break;
		                        case 6 :
		                        	if (cell.getCellType() == CellType.NUMERIC) {
		                        		 dto.setDiscount((int)cell.getNumericCellValue());	
		                        	} else {
		                    			log.error("Incorrect format Discount");
		                               return null;
		                        	}
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
		        	e.printStackTrace();
		        }
		        return null;
		}
			
			
	}