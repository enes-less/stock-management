package com.floproje.StokYonetim.helper;

import com.floproje.StokYonetim.dto.CategoryCreateRequestDTO;
import com.floproje.StokYonetim.dto.CategoryCreateResponseDTO;
import com.floproje.StokYonetim.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    //CategoryCreateRequestDTO -> Category
    public Category mapCategoryCreateRequestDTOToCategory(CategoryCreateRequestDTO dto){
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());

        return category;
    }
    //Category -> CategoryCreateResponseDTO
    public CategoryCreateResponseDTO mapCategoryToCategoryCreateResponseDTO(Category category) {
        CategoryCreateResponseDTO dto = new CategoryCreateResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        dto.setProducts(category.getProducts());

        return dto;
    }
}
