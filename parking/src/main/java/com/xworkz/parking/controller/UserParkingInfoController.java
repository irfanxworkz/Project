package com.xworkz.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.parking.dto.UserInfoDTO;
import com.xworkz.parking.dto.UserParkingInfoDTO;
import com.xworkz.parking.entity.UserInfoEntity;
import com.xworkz.parking.entity.UserParkingInfoEntity;
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
	
	
	@PostMapping(value = "/userotp")
	public String sendOTP(String email,UserInfoEntity userInfoEntity, Model model, HttpServletRequest req) {
		log.info("Running send otp method..");
		UserInfoDTO userInfoDTO2=this.parkingServices.sendOTP(email, userInfoEntity);
		if(userInfoDTO2 != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("utp", userInfoDTO2);
			model.addAttribute("otpmsg", "Enter OTP Send to user mail id");
			return "/UserLogin.jsp";
		}else {
			model.addAttribute("otpmsg1", "OTP send failed");
			return "/UserOTP.jsp";
		}
		
	}
	@PostMapping(value = "/userlogin")
	public String userLogin(String email,String oneTimePassword,/* int userId,*/ Model model, HttpServletRequest req) {
		log.info("Running userLogin() method in UserParkingInfoController...");
			UserInfoDTO userInfoDTO2 = this.parkingServices.loginUser(email,oneTimePassword);
			//UserParkingInfoDTO userParkingInfoDTO =this.parkingServices.findByUserId(email,userId);
			if (userInfoDTO2 != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("userInfoDTO", userInfoDTO2);
				//session.setAttribute("userParkingInfoDTO", userParkingInfoDTO);
				return "/UserDetails.jsp";
			} else {
				model.addAttribute("msg", "OTP is invalid please Enter Correct OTP ");
				return "/UserLogin.jsp";
			}
		} 

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  