package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductCreateResponseDTO;
import com.floproje.StokYonetim.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//http://localhost:8080/products/*

@RestController
@RequiredArgsConstructor
@RequestMapping("/product") //! products diye baslayan butun istekler artik bu controller'da karsilanir.
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello World!"); //200 OK
    }

    @PostMapping
    public ResponseEntity<ProductCreateResponseDTO> saveProduct(@RequestBody ProductCreateRequestDTO dto){
        return new ResponseEntity<>(productService.saveProduct(dto), HttpStatus.CREATED);
    }

    //findProductById
    //ipucu @GetMapping("/{id}"),
    //parametre olarak @PathVariable Long id
    @GetMapping("/{id}")
public ResponseEntity<ProductCreateResponseDTO> findProductById(@PathVariable Long id) {
    return ResponseEntity.ok(productService.findProductById(id));
}
}
