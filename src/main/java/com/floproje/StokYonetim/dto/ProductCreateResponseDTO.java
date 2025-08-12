package com.floproje.StokYonetim.dto;

import com.floproje.StokYonetim.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponseDTO {
    private Long id;

    private String name;

    private String description;

    private Integer stock;

    private Category category;
}
