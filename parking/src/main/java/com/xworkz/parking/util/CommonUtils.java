package com.xworkz.parking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import com.xworkz.parking.dto.ParkingInfoDTO;

public class CommonUtils {

	/*
    public static List<ParkingInfoDTO> readExcel(InputStream inputStream) throws IOException {
        List<ParkingInfoDTO> excelDataList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();

            if (currentRow.getRowNum() == 0) {
                // Skip header row
                continue;
            }

            ParkingInfoDTO parkingInfoDTO = new ParkingInfoDTO();
            parkingInfoDTO.setId((int) currentRow.getCell(0).getNumericCellValue());
            parkingInfoDTO.setLocation(currentRow.getCell(1).getStringCellValue());
            parkingInfoDTO.setType(currentRow.getCell(2).getStringCellValue());
            parkingInfoDTO.setClassification(currentRow.getCell(3).getStringCellValue());
            parkingInfoDTO.setTerms(currentRow.getCell(4).getStringCellValue());
            parkingInfoDTO.setPrice(currentRow.getCell(5).getNumericCellValue());
            parkingInfoDTO.setDiscount(currentRow.getCell(6).getStringCellValue());

            excelDataList.add(parkingInfoDTO);
        }

        workbook.close();
        return excelDataList;
    }
    
    */
	/*
	@Controller
	@RequestMapping("/")
	public class YourController {

	    private final YourService yourService;

	    public YourController(YourService yourService) {
	        this.yourService = yourService;
	    }

	    @PostMapping("/updateDataFromExcel")
	    public String updateDataFromExcel(@RequestParam("excelFile") MultipartFile excelFile, Model model) {
	        if (!excelFile.isEmpty()) {
	            try {
	                List<ParkingInfoDTO> excelDataList = ExcelUtils.readExcel(excelFile.getInputStream());

	                yourService.updateDataFromExcel(excelDataList);

	                model.addAttribute("message", "Data updated successfully from Excel.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                model.addAttribute("message1", "Failed to update data from Excel.");
	            }
	        } else {
	            model.addAttribute("message1", "Please select an Excel file to update data.");
	        }

	        return "redirect:/yourPage"; // Redirect back to your page
	    }
	}
	*/
	/*
	@Service
	public class YourService {

	    private final YourRepository yourRepository; // Assuming you have a repository

	    public YourService(YourRepository yourRepository) {
	        this.yourRepository = yourRepository;
	    }

	    @Transactional
	    public void updateDataFromExcel(List<ParkingInfoDTO> excelDataList) {
	        for (ParkingInfoDTO parkingInfoDTO : excelDataList) {
	            Optional<YourEntity> optionalEntity = yourRepository.findById(parkingInfoDTO.getId());

	            if (optionalEntity.isPresent()) {
	                YourEntity entity = optionalEntity.get();
	                entity.setLocation(parkingInfoDTO.getLocation());
	                entity.setType(parkingInfoDTO.getType());
	                entity.setClassification(parkingInfoDTO.getClassification());
	                entity.setTerms(parkingInfoDTO.getTerms());
	                entity.setPrice(parkingInfoDTO.getPrice());
	                entity.setDiscount(parkingInfoDTO.getDiscount());

	                yourRepository.save(entity);
	            }
	        }
	    }
	}
	*/
	/*
	Controller
	@RequestMapping("/")
	public class YourController {

	    @Autowired
	    private YourService yourService;

	    @PostMapping("/updateDataFromExcel")
	    public String updateDataFromExcel(@RequestParam("excelFile") MultipartFile excelFile, Model model) {
	        if (!excelFile.isEmpty()) {
	            try {
	                List<ParkingInfoDTO> excelDataList = ExcelUtils.readExcel(excelFile.getInputStream());

	                yourService.updateDataFromExcel(excelDataList);

	                model.addAttribute("message", "Data updated successfully from Excel.");
	            } catch (IOException e) {
	                e.printStackTrace();
	                model.addAttribute("message1", "Failed to update data from Excel.");
	            }
	        } else {
	            model.addAttribute("message1", "Please select an Excel file to update data.");
	        }

	        return "redirect:/yourPage"; // Redirect back to your page
	    }
	}
	*/
}
