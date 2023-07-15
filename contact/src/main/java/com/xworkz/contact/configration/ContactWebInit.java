package com.xworkz.contact.configration;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.xworkz.contact.constants.ContactConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContactWebInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	public ContactWebInit() {
		log.info("Creating no-arg Constructor using ContactWebInit!!!");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ContactConfigration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		int maxSize = ContactConstant.MAX_FILE_SIZE;
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(ContactConstant.TEMP_FILE_LOCATION, maxSize, maxSize * 2, maxSize /2);
		registration.setMultipartConfig(multipartConfigElement);
	}
}