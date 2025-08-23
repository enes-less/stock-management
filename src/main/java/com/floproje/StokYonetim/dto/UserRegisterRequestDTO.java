package com.floproje.StokYonetim.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserRegisterRequestDTO {
    @NotBlank(message = "Username must be entered.")
    private String username;

    @NotBlank(message = "First name must be entered.")
    private String firstName;

    @NotBlank(message = "Last name must be entered.")
    private String lastName;

    @NotBlank(message = "Password must be entered.")
    private String password;

    @NotBlank(message = "Phone number must be entered.")
    private String phoneNumber;

    @NotBlank(message = "Email must be entered.")
    private String email;
}
