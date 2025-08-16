package com.floproje.StokYonetim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequestDTO {

    @NotBlank(message = "Category name cannot be empty.")
    private String name;

    private String description;
}
