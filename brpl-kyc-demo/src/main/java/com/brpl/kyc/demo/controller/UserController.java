package com.brpl.kyc.demo.controller;

<<<<<<< HEAD
import java.io.IOException;

=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
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

<<<<<<< HEAD
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
import com.brpl.kyc.demo.FileHandling;
import com.brpl.kyc.demo.model.KYCRequest;
import com.brpl.kyc.demo.model.KYCUser;
import com.brpl.kyc.demo.model.User;
import com.brpl.kyc.demo.repository.KYCRequestRepository;
import com.brpl.kyc.demo.repository.KYCUserRepository;
import com.brpl.kyc.demo.repository.UserRepository;
import com.brpl.kyc.demo.service.KYCService;
import com.brpl.kyc.demo.service.UserService;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins="http://localhost:5500")
public class UserController {
<<<<<<< HEAD
	
    @Autowired
    private AmazonS3 amazonS3Client;
=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636

	@Autowired
	private KYCService kycService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FileHandling handleFile;
	
	@Autowired
	private KYCUserRepository kycUserRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private KYCRequestRepository kycRepo;
	
<<<<<<< HEAD
	@Autowired
	private KYCUserRepository kycUserRepo;
	
	@Value("${upload.image}")
	private String path;
	
	private static final String BUCKET_NAME = "brpl-aadhar-pan-bucket";
	
=======
	@Value("${upload.image}")
	private String path;
	
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
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
	
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
=======

>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
	@PostMapping("/kycData")
	public ResponseEntity<?> creatingUserKycData(@RequestBody KYCUser kyc) {
		KYCUser kycUser = kycUserRepo.save(kyc);
		return ResponseEntity.ok(kycUser);
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> getEmailOfUser(@PathVariable String email) {
<<<<<<< HEAD
<<<<<<< HEAD
		User user = null;
		try {
			user = userRepo.findByEmail(email);			
			return ResponseEntity.ok(user);
		} catch(RuntimeException ex) {
			return ResponseEntity.badRequest().body("Invalid user emailId: " + ex.getMessage());
		}
=======
		User user = userRepo.findByEmail(email);
		return ResponseEntity.ok(user);
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
=======
		User user = userRepo.findByEmail(email);
		return ResponseEntity.ok(user);
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
	}
	
	@PostMapping("/{userId}/kyc")
	public ResponseEntity<?> submitKycRequest(@PathVariable Long userId,
											@RequestParam("aadharImage") MultipartFile aadharImage,
											@RequestParam("pancardImage") MultipartFile pancardImage
										) {
		
		try {
<<<<<<< HEAD
//			String afname = handleFile.uploadImage(aadharImage, path);
//			String pfname = handleFile.uploadImage(pancardImage, path);
			
<<<<<<< HEAD
            // Upload Aadhar image to S3
            String afname = uploadToS3(aadharImage, "aadhar", userId);

            // Upload Pancard image to S3
            String pfname = uploadToS3(pancardImage, "pancard", userId);
			
=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
=======
			String afname = handleFile.uploadImage(aadharImage, path);
			String pfname = handleFile.uploadImage(pancardImage, path);
			
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
			kycService.submitKycRequest(userId, afname, pfname);
			
			return ResponseEntity.ok().build();
		} catch(Exception ex) {
			return ResponseEntity.badRequest().body("Failed to submit KYC request: " + ex.getMessage());
		}		
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
	@GetMapping("/{userId}/getKyc")
	public ResponseEntity<?> getUserKyc(@PathVariable Long userId) {
		try {
			
			KYCRequest kycUserRequest = kycService.getKycRequestByUserId(userId);
			
			return ResponseEntity.ok(kycUserRequest);
		} catch(Exception ex) {
			return ResponseEntity.badRequest().body("Failed to fetch KYC request: " + ex.getMessage());
		}
	}
<<<<<<< HEAD
	
	
    private String uploadToS3(MultipartFile file, String type, Long userId) throws IOException {
        String keyName = userId + "/" + type + ".jpg"; // Example keyName: 123/aadhar.jpg
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/jpeg"); // Set content type if necessary
        metadata.setContentLength(file.getSize()); // Set content length

        amazonS3Client.putObject(new PutObjectRequest(BUCKET_NAME, keyName, file.getInputStream(), metadata));
        return keyName; // Return the S3 key for the uploaded file
    }
	
=======
>>>>>>> c33a3474e4a60fbadbe1fff3ca2005bdd9c2a636
}
