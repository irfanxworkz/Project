package com.xworkz.parking.controller;

import java.util.List;

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
import com.xworkz.parking.services.ParkingServices;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class UserParkingInfoController {

	@Autowired
	private ParkingServices parkingServices;

	//this method for user registration */
	@PostMapping(value = "/userReg")
	public String userRegistration(UserInfoDTO userInfoDTO, Model model) {
		boolean status = this.parkingServices.userRegistration(userInfoDTO);
		if (status) {
			model.addAttribute("UserRegMsg", "User Successfully Register");
		} else {
			model.addAttribute("error", "Email-id is already exist");
		}
		return "/UserReg.jsp";
	}

	//this method for sent otp on user mail id */
	@PostMapping(value = "/userotp")
	public String sendOTP(String email, Model model, HttpServletRequest req) {
		log.info("Running send otp method..");
		UserInfoDTO userInfoDTO2 = this.parkingServices.sendOTP(email);
		if (userInfoDTO2 != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("utp", userInfoDTO2);
			model.addAttribute("otpmsg", "Enter OTP Send to user mail id");
			return "/UserLogin.jsp";
		} else {
			model.addAttribute("otpmsg1", "Email id does not exist");
			return "/UserOTP.jsp";
		}
	}

	//this method for user login
	@PostMapping(value = "/userlogin")
	public String userLogin(String email, String oneTimePassword, Model model, HttpServletRequest req) {
		log.info("Running userLogin() method in UserParkingInfoController...");
		UserInfoDTO userInfoDTO2 = this.parkingServices.loginUser(email, oneTimePassword);
		if (userInfoDTO2 != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userInfoDTO", userInfoDTO2);
			return "/UserDetails.jsp";
		} else {
			model.addAttribute("msg", "OTP is invalid please Enter Correct OTP ");
			return "/UserLogin.jsp";
		}
	}
	
	//this method for add user parking information */
	@PostMapping(value = "/addUser")
	public String addUserParkingInfo(String email, UserParkingInfoDTO userParkingInfoDTO, Model model) {
		boolean status = this.parkingServices.saveUserParkingInfo(email, userParkingInfoDTO);
		if (status) {
			model.addAttribute("userparking", userParkingInfoDTO.getClassification() +" Parked in "+userParkingInfoDTO.getLocation() +" Successfully... ");
		} else {
			model.addAttribute("already", "data is already exist");
		}
		return "/UserInfo.jsp";
	}

	//this method for View user parking information */
	@PostMapping(value = "/userParkingView")
	public String viewUserParkingInfo(String viewParkingInfo, Model model, HttpServletRequest req) {
			UserInfoDTO userInfoDTO2 = this.parkingServices.viewUserData(viewParkingInfo);
			//TODO : null check
			List<UserParkingInfoDTO>  userParkingInfoDTO =this.parkingServices.findByUserId(userInfoDTO2.getId());
			System.err.println("Faching from findByuserId userParkingInfoDTO : "+userParkingInfoDTO);
			if (userInfoDTO2 != null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("userParkingInfoDTO", userParkingInfoDTO);
				return "/ViewUserData.jsp";
			}
			return null; 
	}
	
	//this method for update user information */
	@PostMapping(value = "/editUserParking")
	public String findById(int id,Model model,HttpServletRequest req) {
		log.info("Running updateUserParkingInfo method in USerPArkingInfoController....");
		UserParkingInfoDTO userParkingInfoDTO= this.parkingServices.findById(id);
		if(userParkingInfoDTO != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("parkingData", userParkingInfoDTO);
			return "/UpdateUserParking.jsp";
		}
			return null;
		}
	
	//this method for update user parking information 
	@PostMapping("/updateInfo")
	public String updateUserParkingInfo(int id,String location, String type,String classification,String terms,
			double price,String discount, double totalAmount, Model model,HttpServletRequest req) {
		UserParkingInfoDTO userParkingInfoDTO= this.parkingServices.updateUserParkingInfo(id, location, type, classification, terms, price, discount, totalAmount);
		System.err.println("Value of userParkingInfoDTO in controller : "+userParkingInfoDTO);
		if(userParkingInfoDTO != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("successUpdate", userParkingInfoDTO);
			model.addAttribute("UpdateMsg", " user parking information updated Successfully... ");
			return "/UpdateUserSuccess.jsp";
		}else {
			model.addAttribute("error","something went wrong....");
			return "/UpdateUserParking.jsp";
	       }
	    }
	
	
	}
