package com.demo.jwtinaction.service;

import com.demo.jwtinaction.data.entities.Role;
import com.demo.jwtinaction.data.entities.User;
import com.demo.jwtinaction.data.repository.UserRepository;
import com.demo.jwtinaction.dto.RegistrationAndAuthRequest;
import com.demo.jwtinaction.security.jwt.JwtImplementationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RegistrationAndAuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtImplementationService jwtImplementationService;

    public RegistrationAndAuthService(PasswordEncoder passwordEncoder, UserRepository userRepository,
                                      AuthenticationManager authenticationManager,
                                      JwtImplementationService jwtImplementationService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtImplementationService = jwtImplementationService;
    }

    public boolean registerUser(RegistrationAndAuthRequest userRequest){
        if(userRepository.findUserByUsername(userRequest.username()) != null){
            return false;
        }
        User user = new User(userRequest.username(), passwordEncoder.encode(userRequest.password()), Role.USER);
        userRepository.save(user);
        return true;
    }

    public String authenticate(RegistrationAndAuthRequest userRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.username(),userRequest.password()));
        UserDetails user = userRepository.findUserByUsername(userRequest.username());
        return jwtImplementationService.generateToken(new HashMap<>(),user);
    }

}
