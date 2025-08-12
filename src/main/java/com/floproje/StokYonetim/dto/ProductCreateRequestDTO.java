package com.floproje.StokYonetim.dto;

import com.floproje.StokYonetim.entity.Category;
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
public class ProductCreateRequestDTO {
    //@NotNull() //null
    //@NotEmpty //""
    @NotBlank(message = "Product name cannot be empty!")//"    ", NotEmpty'i kapsar. NotNull'i da kapsar.
    private String name;

    @NotBlank(message = "Product name cannot be empty!")
    @Length(min = 16, max = 10000, message = "Description must be between ${min}-${max} characters.")
    private String description;

    @Max(50000)
    @Min(1000)
    private Integer stock;

    @NotNull
    private Category category;
}
