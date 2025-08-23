package com.floproje.StokYonetim.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequestDTO {
    @NotBlank(message = "Username must be entered.")
    private String username;

    @NotBlank(message = "Password must be entered.")
    private String password;
}
