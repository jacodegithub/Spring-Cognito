package com.brpl.kyc.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brpl.kyc.demo.controller.UserController;
import com.brpl.kyc.demo.model.KYCRequest;
<<<<<<< HEAD
=======
import com.brpl.kyc.demo.model.KYCUser;
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
import com.brpl.kyc.demo.model.User;
import com.brpl.kyc.demo.repository.KYCRequestRepository;
import com.brpl.kyc.demo.repository.UserRepository;

@Service
public class KYCService {

	@Autowired 
	private KYCRequestRepository kycRequestRepo;
	@Autowired 
	private UserRepository userRepo;
	
	private Logger log = LoggerFactory.getLogger(KYCService.class);
	
<<<<<<< HEAD
	public void submitKycRequest(Long userId, String aadharImage, String pancardImage) throws IOException {
		User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Invalid userId "+userId));
		
		KYCRequest kycRequest = new KYCRequest();
		kycRequest.setUser(user);
=======
	public void submitKycRequest(KYCUser kycUser, String aadharImage, String pancardImage) throws IOException {
		String email = kycUser.getEmail();
		User user = null;
		try {
			user = userRepo.findByEmail(email);			
		}catch(Exception ex) {
			System.out.println("Invalid user emailId "+email);
		}
		
		KYCRequest kycRequest = new KYCRequest();
		kycRequest.setUser(user);
		kycRequest.setKycUser(kycUser);
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
		kycRequest.setAadharImage(aadharImage);
		kycRequest.setPancardImage(pancardImage);
		
		kycRequestRepo.save(kycRequest);
	}
	
	public KYCRequest getKycRequestByUserId(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(
				() -> new RuntimeException("Invalid userid "+userId)
		);
		
		KYCRequest kycRequest = kycRequestRepo.findByUser(user);
		
		return kycRequest;
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> b274fc9deaf7ad554f0e75d39cca1376a6ded153
}
