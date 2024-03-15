package com.brpl.kyc.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.brpl.kyc.demo.FileHandling;
import com.brpl.kyc.demo.model.KYCRequest;
import com.brpl.kyc.demo.model.KYCUser;
import com.brpl.kyc.demo.model.User;
import com.brpl.kyc.demo.repository.KYCRequestRepository;
import com.brpl.kyc.demo.repository.UserRepository;
import com.brpl.kyc.demo.service.KYCService;
import com.brpl.kyc.demo.service.UserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins="http://localhost:5500")
public class UserController {

	@Autowired
	private KYCService kycService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileHandling handleFile;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private KYCRequestRepository kycRepo;
	
	@Value("${upload.image}")
	private String path;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/check")
	public String testing() {
		return "Hell, yeah, it is working!";
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		try {
			userService.createUser(user);
			log.info("this is the user : {} ",user.getFirstName() );
			return ResponseEntity.ok(user);
		} catch(Exception ex) {
//			return ResponseEntity.badRequest().body("Failed to create user: " + ex.getMessage());
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR).ok().body("Failed to create user: " + ex.getMessage());
		}
	}
	
	@PostMapping("/create/kyc")
	public ResponseEntity<?> submitKycRequest(
											@RequestBody KYCUser kycUser,
											@RequestParam("aadharImage") MultipartFile aadharImage,
											@RequestParam("pancardImage") MultipartFile pancardImage
										) {
		
		try {
			String afname = handleFile.uploadImage(aadharImage, path);
			String pfname = handleFile.uploadImage(pancardImage, path);
			
			kycService.submitKycRequest(kycUser, afname, pfname);
			
			return ResponseEntity.ok().build();
		} catch(Exception ex) {
			return ResponseEntity.badRequest().body("Failed to submit KYC request: " + ex.getMessage());
		}		
	}
	
	@GetMapping("/{userId}/getKyc")
	public ResponseEntity<?> getUserKyc(@PathVariable Long userId) {
		try {
			
			KYCRequest kycUserRequest = kycService.getKycRequestByUserId(userId);
			
			return ResponseEntity.ok(kycUserRequest);
		} catch(Exception ex) {
			return ResponseEntity.badRequest().body("Failed to fetch KYC request: " + ex.getMessage());
		}
	}
}
