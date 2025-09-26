package com.floproje.StokYonetim.security.service;

import com.floproje.StokYonetim.dto.UserLoginRequestDTO;
import com.floproje.StokYonetim.dto.UserRegisterRequestDTO;
import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.entity.UserRole;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.exception.ConflictException;
import com.floproje.StokYonetim.exception.EntityNotFoundException;
import com.floproje.StokYonetim.security.JwtUtils;
import com.floproje.StokYonetim.service.UserRoleService;
import com.floproje.StokYonetim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.PermitAll;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    // Kullanıcı login olur ve authenticationManager ile doğrulama yapılır
    // Eğer kullanıcı adı/şifre doğruysa JWT token üretilir
    public String login(UserLoginRequestDTO request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return jwtUtils.generateToken(auth);
    }

    // Yeni kullanıcı kaydı -> default olarak PERSONNEL rolü atanır
    @PermitAll
    public void register(UserRegisterRequestDTO dto) {
        // Eğer aynı kullanıcı adı varsa hata fırlat
        try {
            if (userService.findByUsername(dto.getUsername()) != null){
                throw new ConflictException("A user with username: " + dto.getUsername() + " already exists.");
            }
        } catch (EntityNotFoundException ignored) {
        }

        // Yeni kullanıcı nesnesi oluştur
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());

        //Defualt role: PERSONNEL
        UserRole userRole = userRoleService.findByRole(Role.PERSONNEL);
        user.setUserRole(userRole);
        userService.saveUser(user);
    }
}
