package com.xworkz.parking.repository;

import java.util.List;

import com.xworkz.parking.entity.ExcelEntity;

public interface ExcelRepository{

	boolean saveParkinghrowExcel(List<ExcelEntity> entities);

}
