package com.chan.email_auth.controller;

import com.chan.email_auth.email.CompleteRegistrationDTO;
import com.chan.email_auth.users.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsersService userService;

    public AuthController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/initiate-email")
    public ResponseEntity<String> initiateEmail(@RequestParam String email) {
        userService.initiateEmailRegistration(email);
        return ResponseEntity.ok("Please check your email to verify.");
    }

    @GetMapping("/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam String token) {
        boolean success = userService.verifyEmail(token);
        if (success) {
            return ResponseEntity.ok("Email verified! Now you can complete registration.");
        } else {
            return ResponseEntity.badRequest().body("Invalid token.");
        }
    }

    @PostMapping("/complete-registration")
    public ResponseEntity<String> completeRegistration(@RequestBody CompleteRegistrationDTO dto) {
        userService.completeRegistration(dto.getEmail(), dto.getPassword(), dto.getFullName(), dto.getPhoneNumber());
        return ResponseEntity.ok("Registration completed!");
    }
}

