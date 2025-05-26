package com.dijitalkart.controller;

import com.dijitalkart.dto.JwtResponse;
import com.dijitalkart.dto.LoginRequest;
import com.dijitalkart.dto.SignupRequest;
import com.dijitalkart.model.User;
import com.dijitalkart.repository.UserRepository;
import com.dijitalkart.security.JwtUtils;
import com.dijitalkart.security.UserPrincipal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
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
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getEmail()));
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        Map<String, String> response = new HashMap<>();
        
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            response.put("message", "Bu email adresi zaten kullanılıyor!");
            return ResponseEntity.badRequest().body(response);
        }
        
        // Create new user's account
        User user = new User(signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        
        userRepository.save(user);
        
        response.put("message", "Kullanıcı başarıyla kayıt edildi!");
        return ResponseEntity.ok(response);
    }
} 