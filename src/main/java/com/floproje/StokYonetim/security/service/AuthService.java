package com.floproje.StokYonetim.security.service;
import com.floproje.StokYonetim.dto.LoginRequest;
import com.floproje.StokYonetim.dto.RegisterRequest;
import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.entity.UserRole;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.repository.UserRepository;
import com.floproje.StokYonetim.repository.UserRoleRepository;
import com.floproje.StokYonetim.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    // Kullanıcı login olur ve authenticationManager ile doğrulama yapılır
    // Eğer kullanıcı adı/şifre doğruysa JWT token üretilir
    public String login(LoginRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        return jwtUtils.generateToken(auth);
    }

    // Yeni kullanıcı kaydı -> default olarak PERSONNEL rolü atanır
    public void register(RegisterRequest req) {
        // Eğer aynı kullanıcı adı varsa hata fırlat
        userRepository.findByUsername(req.getUsername()).ifPresent(u -> {
            throw new RuntimeException("Username already exists");
        });

        // Yeni kullanıcı nesnesi oluştur
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        // Default rol: PERSONNEL
        UserRole role = userRoleRepository.findByRole(Role.PERSONNEL)
                .orElseGet(() -> {
                    UserRole r = new UserRole();
                    r.setRole(Role.PERSONNEL);
                    return userRoleRepository.save(r);
                });

        user.setUserRole(role);

        userRepository.save(user);
    }
}
