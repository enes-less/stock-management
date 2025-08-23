package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.entity.UserRole;
import com.floproje.StokYonetim.enums.Role;
import com.floproje.StokYonetim.exception.EntityNotFoundException;
import com.floproje.StokYonetim.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public void save(UserRole userRole){
        userRoleRepository.save(userRole);
    }

    public UserRole findByRole(Role role){
        return userRoleRepository.findByRole(role)
                .orElseThrow(() -> new EntityNotFoundException("No UserRole found with given role: " + role));
    }

    public List<UserRole> findAll(){
        return userRoleRepository.findAll();
    }
}
