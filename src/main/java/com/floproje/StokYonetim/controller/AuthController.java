package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.UserLoginRequestDTO;
import com.floproje.StokYonetim.dto.UserRegisterRequestDTO;
import com.floproje.StokYonetim.security.service.AuthService; // düzeltildi
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // giriş endpointi
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginRequestDTO dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok(token);
    }

    // kayıt endpointi
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterRequestDTO dto) {
        authService.register(dto);
        return ResponseEntity.ok("User registered successfully");
    }
}
