package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.CategoryCreateRequestDTO;
import com.floproje.StokYonetim.dto.CategoryCreateResponseDTO;
import com.floproje.StokYonetim.entity.Category;
import com.floproje.StokYonetim.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER')")
    public ResponseEntity<CategoryCreateResponseDTO> saveCategory(@RequestBody CategoryCreateRequestDTO dto) {
        return new ResponseEntity<>(categoryService.saveCategory(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
}
