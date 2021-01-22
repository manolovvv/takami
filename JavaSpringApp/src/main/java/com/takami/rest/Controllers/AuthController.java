package com.takami.rest.Controllers;


import com.takami.rest.Requests.RequestSignUp;
import com.takami.rest.jwt.JwtResponse;
import com.takami.rest.jwt.JwtUtils;
import com.takami.rest.jwt.LoginRequest;
import com.takami.rest.jwt.UserDetailsImpl;
import com.takami.rest.model.ERole;
import com.takami.rest.model.User;
import com.takami.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Long id = userDetails.getId();

        return ResponseEntity.ok(new JwtResponse(jwt,roles,id));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody /*User*/ RequestSignUp signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        user.setFirstName(signUpRequest.getFamilyName());
        user.setFamilyName(signUpRequest.getFamilyName());
        user.setAddress(signUpRequest.getAddress());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(ERole.ROLE_USER);
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully!");
    }
}
