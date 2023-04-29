package com.demo.jwtinaction.controller;


import com.demo.jwtinaction.dto.RegistrationAndAuthRequest;
import com.demo.jwtinaction.service.RegistrationAndAuthService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
public class Controller {

    private final RegistrationAndAuthService registrationAndAuthService;

    public Controller(RegistrationAndAuthService registrationAndAuthService) {
        this.registrationAndAuthService = registrationAndAuthService;
    }

    @GetMapping("/api/v1/user/hello")
    public ResponseEntity<String> responseEntity(){
        return new ResponseEntity<>("Hello World", HttpStatusCode.valueOf(200));
    }

    @PostMapping("/api/v1/user/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationAndAuthRequest request){

        if(request.username() == null || request.password() == null)
            return new ResponseEntity<>("Invalid Details",HttpStatusCode.valueOf(401));

        //TODO: Create and Call method in RegistrationAndAuthService class , register()

        return new ResponseEntity<>("Registration complete",HttpStatusCode.valueOf(200));
    }

    @PostMapping("/api/v1/user/sign-in")
    public ResponseEntity<String> authenticateUser(@RequestBody RegistrationAndAuthRequest request){
        if(request.username() == null || request.password() == null)
            return new ResponseEntity<>("Invalid Details",HttpStatusCode.valueOf(401));
        //TODO : Create and call method in RegistrationAndAuthService, authenticate
        return new ResponseEntity<>("Need to add jwt token in header and also print it",HttpStatusCode.valueOf(200));
    }

}
