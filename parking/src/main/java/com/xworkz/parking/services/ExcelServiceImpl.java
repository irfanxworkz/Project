package com.xworkz.parking.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.parking.dto.ExcelDataDTO;
import com.xworkz.parking.entity.ExcelEntity;
import com.xworkz.parking.repository.ExcelRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ExcelServiceImpl implements ExcelService{
	
	@Autowired
	ExcelRepository excelRepository;
	
	@Override
	public boolean saveParkingThrowExcel(MultipartFile file){
		log.info("Running saveParkingThrowExcel() method in ExcelServiceImpl....");
	try {
	        List<ExcelDataDTO> excelDataDTOs = ExcelUploadService.getDataFromExcel(file.getInputStream());
	        if (excelDataDTOs == null) {
	            return false;
	        }
	        
	        log.info("Excel DTO values: " + excelDataDTOs);
	        List<ExcelEntity> entities = new ArrayList<>();
	        for (ExcelDataDTO dto : excelDataDTOs) {
	            ExcelEntity entity = new ExcelEntity();
	            // Copy properties from DTO to Entity
	            BeanUtils.copyProperties(dto, entity);
	            entities.add(entity);
	        }
	        
	        if (entities.isEmpty()) {
	            log.info("Entity is empty; please select the correct file");
	            return false;
	        }
	        
	        log.info("List Entity value of parkingInfo : " + entities);
	        boolean status = this.excelRepository.saveParkinghrowExcel(entities);
	        if (status) {
	            log.info("Save data in the database");
	        } else {
	            log.info("Data not saved in the database");
	        }
	        return status;

	    } catch (IOException e) {
	        log.error("Error processing Excel file", e);
	        return false;
	    }
	}
}