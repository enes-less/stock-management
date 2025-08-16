package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.CategoryCreateRequestDTO;
import com.floproje.StokYonetim.dto.CategoryCreateResponseDTO;
import com.floproje.StokYonetim.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World!"); //200 OK
    }

    @PostMapping
    public ResponseEntity<CategoryCreateResponseDTO> saveCategory(@RequestBody CategoryCreateRequestDTO dto) {
        return new ResponseEntity<>(categoryService.saveCategory(dto), HttpStatus.CREATED);
    }
}
