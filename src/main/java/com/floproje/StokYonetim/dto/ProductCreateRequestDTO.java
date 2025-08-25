package com.floproje.StokYonetim.dto;

import com.floproje.StokYonetim.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequestDTO {
    //@NotNull() //null
    //@NotEmpty //""
    @NotBlank(message = "Product name cannot be empty!")//"    ", NotEmpty'i kapsar. NotNull'i da kapsar.
    private String name;

    @NotBlank(message = "Product name cannot be empty!")
    @Length(min = 16, max = 10000, message = "Description must be between ${min}-${max} characters.")
    private String description;

    @Max(value = 5000, message = "Stock value must not exceed 5000.")
    @Min(value = 100, message = "Stock value must not be lower than 100.")
    @NotNull(message = "Stock must be entered!")
    private Integer stock;

    @Max(value = 50, message = "ROP percentage cannot exceed 50%.")
    @Min(value = 5, message = "ROP percentage cannot be lower than 5%.")
    @NotNull(message = "ROP must be entered!")
    private Integer rop;

    @NotBlank(message = "SKU cannot be empty!")
    @Length(min = 8, max = 32, message = "SKU must be between ${min}-${max} characters.")
    private String sku;

    @NotNull(message = "Size cannot be empty!")
    private Double size;

    @NotBlank(message = "Color cannot be empty!")
    private String color;

    @Pattern(regexp = "male|female|unisex", message = "Gender can only be 'male' or 'female'")
    private String gender;

    @NotNull(message = "Product price cannot be empty!")
    private Double price;

    @NotNull(message = "isForKids value must be provided.")
    private Boolean isForKids;

    @NotNull(message = "Product category must be selected!")
    private CategoryCreateRequestDTO category;
}
