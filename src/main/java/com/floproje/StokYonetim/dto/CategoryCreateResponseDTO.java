package com.floproje.StokYonetim.dto;

import com.floproje.StokYonetim.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateResponseDTO {
    private Long id;

    private String name;

    private String description;

    private List<Product> products;
}
