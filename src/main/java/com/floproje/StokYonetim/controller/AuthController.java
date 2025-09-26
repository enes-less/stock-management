package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.UserLoginRequestDTO;
import com.floproje.StokYonetim.dto.UserRegisterRequestDTO;
import com.floproje.StokYonetim.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // giriş endpointi
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserLoginRequestDTO dto) {
        String token = authService.login(dto);
        return ResponseEntity.ok(token);
    }

    // kayıt endpointi
    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody UserRegisterRequestDTO dto) {
        System.out.println("REGISTER GELDI");
        authService.register(dto);
        return ResponseEntity.ok("User registered successfully");
    }
}
