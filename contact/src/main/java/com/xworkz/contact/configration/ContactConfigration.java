package com.xworkz.contact.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz")
@EnableWebMvc
@Slf4j
public class ContactConfigration implements WebMvcConfigurer{

	public ContactConfigration() {
		log.info("Creating no-arg constructor using ContactConfigration!!!");
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("contactStart");
		
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
		
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		return localContainerEntityManagerFactoryBean;
		
	}
}
