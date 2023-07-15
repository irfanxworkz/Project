package com.xworkz.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.parking.dto.UserInfoDTO;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.services.ParkingServices;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserParkingInfoController {

	@Autowired
	private ParkingServices parkingServices;
	
	@PostMapping(value ="/user")
	public String userSave(UserInfoDTO userInfoDTO,UserParkingInfoDTO userParkingInfoDTO, Model model) {
		  log.info("running userSave method in UserParkingInfoController...");
		 boolean status = this.parkingServices.userSaveAndValidate(userInfoDTO, userParkingInfoDTO);
		 if(status) {
			 model.addAttribute("usermsg", "infomaton for "+userInfoDTO.getName()+" save successfully");
		 }else {
			 model.addAttribute("error", "Email-id is already exist");	
		 }		  
		return "/UserInfo.jsp";
	}
	
	@PostMapping(value = "/user-login", params = "otp")
	public String sendOTP(String email, Model model, UserInfoEntity userInfoEntity ,UserInfoDTO userInfoDTO) {
		log.info("Running send otp method..");
		if(userInfoEntity.getEmail().equals(email)) {
			this.parkingServices.sendOTP(email, userInfoEntity);
			model.addAttribute("otpmsg", "OTP send to email successfully");
			return "/UserLogin.jsp";
		}else {
			model.addAttribute("otpmsg1", "OTP send failed");
			return "/UserLogin.jsp";
		}
		
	}
	
	@PostMapping(value = "/user-login", params = "login")
	public String userLogin(UserInfoDTO userInfoDTO, Model model, HttpServletRequest req) {
		log.info("Running userLogin() method in UserParkingInfoController...");
		UserInfoDTO userInfoDTO2 = this.parkingServices.loginUser(userInfoDTO.getEmail(),userInfoDTO.getOneTimePassword());
		if (userInfoDTO2 != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userDtos", userInfoDTO2);
			return "/UserDetails.jsp";
		} else {
			model.addAttribute("userloginmsg", "email or password invalid!!! ");
			return "/UserLogin.jsp";
		}
	}

}