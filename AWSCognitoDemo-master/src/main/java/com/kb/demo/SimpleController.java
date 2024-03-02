package com.kb.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping(path = "/api/hello")
    public String getResp(){
        return  "Hey authenticated request!";
    }

    @GetMapping("/")
    public String permitAll() {
    	return "Permit All is Working";
    }
    
    @PostMapping(value = "/admin/greetMe", headers = "Accept=application/json") 
    public ResponseEntity<String> greetingAdmin(@RequestBody User user) {
    	
    	return ResponseEntity.ok("Hello, ADMIN! How do you do? "+user.getUsername()+" "+user.getEmail());
    }
}
