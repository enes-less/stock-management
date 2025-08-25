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
public class ProductResponseDTO {
    private Long id;

    private String name;

    private String description;

    private Integer initialStock;

    private Integer stock;

    private Integer rop;

    private String sku;

    private Double size;

    private String color;

    private String gender;

    private Double price;

    private Boolean isForKids;

    private Category category;
}
