package com.floproje.StokYonetim.repository;

import com.floproje.StokYonetim.entity.User;
import com.floproje.StokYonetim.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); //UserName degil Username dogru

    @Query(value = "SELECT count(u) FROM User u WHERE u.userRole.role = ?1")
    long countAdmin(Role role);
}
