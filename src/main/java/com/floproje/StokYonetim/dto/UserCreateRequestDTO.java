package com.floproje.StokYonetim.dto;

import com.floproje.StokYonetim.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequestDTO {

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private String phoneNumber;

    private String email;

    private UserRole userRole;
}
