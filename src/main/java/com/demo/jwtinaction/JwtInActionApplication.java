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

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public JwtInActionApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtInActionApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User user = new User("User",passwordEncoder.encode("1234"), Role.USER);
            userRepository.save(user);
            UserDetails user1 = userRepository.findUserByUsername("User");
            System.out.println(user1.getPassword());

        };
    }

}
