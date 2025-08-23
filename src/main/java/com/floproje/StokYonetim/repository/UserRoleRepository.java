package com.floproje.StokYonetim.repository;

import com.floproje.StokYonetim.entity.UserRole;
import com.floproje.StokYonetim.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRole(Role role);
}
