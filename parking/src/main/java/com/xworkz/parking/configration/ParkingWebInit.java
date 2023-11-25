package com.xworkz.parking.configration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParkingWebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	
	public ParkingWebInit() {
		log.info("Creating no-arg Constructor using ParkingWebInit!!!");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		/* log.info("Running getRootConfigClasses method..."); */
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		/* log.info("Running getServletConfigClasses method..."); */
		return new Class[] {ParkingConfigration.class};
	}

	@Override
	protected String[] getServletMappings() {
		/* log.info("Running getServletMappings method..."); */
		return new String[] {"/"};
	}
}
