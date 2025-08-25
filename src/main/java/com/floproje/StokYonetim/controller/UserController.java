package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //tüm kullanıcıları listeleme
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUsers(@RequestParam(name = "page") int page,
                                                           @RequestParam(name = "size") int size,
                                                           @RequestParam(name = "sort", required = false) String sortBy,
                                                           @RequestParam(name = "order", required = false) Sort.Direction order) {
        return ResponseEntity.ok(userService.findAll(page, size, sortBy, order));
    }
    //belirli bir kullanıcıyı getir (sadece admin)

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    //kullanıcı silme (sadece admin)

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}