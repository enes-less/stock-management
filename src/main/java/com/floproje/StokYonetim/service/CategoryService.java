package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.CategoryCreateRequestDTO;
import com.floproje.StokYonetim.dto.CategoryCreateResponseDTO;
import com.floproje.StokYonetim.entity.Category;
import com.floproje.StokYonetim.exception.EntityNotFoundException;
import com.floproje.StokYonetim.helper.CategoryMapper;
import com.floproje.StokYonetim.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryCreateResponseDTO saveCategory(CategoryCreateRequestDTO dto) {
        Category category = categoryMapper.mapCategoryCreateRequestDTOToCategory(dto);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryCreateResponseDTO(savedCategory);
    }

    //Optional yapisi, category bulunursa return edilmesini, bulunamazsa (or else) hata firlatilmasini saglar.
    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("No category found with given ID: " + id));
    }

    public CategoryCreateResponseDTO findCategoryById(Long id){
        Category foundCategory = findById(id);
        //eger bu id ile bir category bulunamazsa, bu satir ve sonrasi calismaz.
        return categoryMapper.mapCategoryToCategoryCreateResponseDTO(foundCategory);
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException("No category found with given name: " + name));
    }
}
