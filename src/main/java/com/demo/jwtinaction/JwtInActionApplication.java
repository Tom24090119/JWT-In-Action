package com.demo.jwtinaction;

import com.demo.jwtinaction.data.entities.Role;
import com.demo.jwtinaction.data.entities.User;
import com.demo.jwtinaction.data.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtInActionApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtInActionApplication.class, args);
    }
}
