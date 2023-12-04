package com.xworkz.parking.services;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelService {

	boolean saveParkingThrowExcel(MultipartFile file1);

}
