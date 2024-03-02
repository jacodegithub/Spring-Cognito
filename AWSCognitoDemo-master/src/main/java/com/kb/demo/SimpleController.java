package com.kb.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@Autowired
	private CognitoService cogService;
	
    @GetMapping(path = "/api/hello")
    public String getResp(){
        return  "Hey authenticated request!";
    }

    @GetMapping("/")
    public String permitAll() {
    	return "Permit All is Working";
    }
    
    @PostMapping(value = "/admin/greetMe", consumes = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<String> greetingAdmin(@RequestBody User user) {
    	
    	return ResponseEntity.ok("Hello, ADMIN! How do you do? "+user.getUsername()+" "+user.getEmail());
    }
    
  @PostMapping("/admin/register-user")
  public String registerUser(@RequestBody User user) {
  	try {
  		cogService.addUserToUserPool(user.getUsername(), user.getEmail(), user.getPassword());
  		return "Registratoin-Successful";
  	}catch(Exception ex) {	
  		return "Registration-Error!";
  	}
  }
}
