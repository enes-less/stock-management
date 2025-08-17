package com.floproje.StokYonetim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequestDTO {
    @NotBlank(message = "Product name cannot be empty!")//"    ", NotEmpty'i kapsar. NotNull'i da kapsar.
    private String name;

    @NotBlank(message = "Product name cannot be empty!")
    @Length(min = 16, max = 10000, message = "Description must be between ${min}-${max} characters.")
    private String description;

    @Max(value = 5000, message = "Stock value must not exceed 5000.")
    @Min(value = 100, message = "Stock value must not be lower than 100.")
    @NotNull(message = "Stock must be entered!")
    private Integer stock;

    @NotNull(message = "Size cannot be empty!")
    private Double size;

    @NotBlank(message = "Color cannot be empty!")
    private String color;

    @Pattern(regexp = "male|female", message = "Gender can only be 'male' or 'female'")
    private String gender;

    @NotNull(message = "Product price cannot be empty!")
    private Double price;

    @NotNull(message = "isForKids value must be provided.")
    private Boolean isForKids;

    @NotNull(message = "Product category must be selected!")
    private CategoryCreateRequestDTO category;
}
