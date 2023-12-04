package com.xworkz.parking.repository;

import java.util.List;

import com.xworkz.parking.entity.ParkingInfoEntity;


public interface ExcelRepository{

	boolean saveParkinghrowExcel(List<ParkingInfoEntity> entities);


}
