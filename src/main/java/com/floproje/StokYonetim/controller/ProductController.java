package com.floproje.StokYonetim.controller;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductResponseDTO;
import com.floproje.StokYonetim.dto.ProductUpdateRequestDTO;
import com.floproje.StokYonetim.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//http://localhost:8080/product*

@RestController
@RequiredArgsConstructor
@RequestMapping("/product") //! products diye baslayan butun istekler artik bu controller'da karsilanir.
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> saveProduct(@RequestBody ProductCreateRequestDTO dto){
        return new ResponseEntity<>(productService.saveProduct(dto), HttpStatus.CREATED);
    }

    //findProductById
    //ipucu @GetMapping("/{id}"),
    //parametre olarak @PathVariable Long id
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    //! Pagination: URL icerisinde -> abc.com/product?page=1&size=25&sort=name&order=DESC
    @GetMapping
    public ResponseEntity<Map<String, Object>> findAllProducts(@RequestParam(name = "page") int page,
                                                               @RequestParam(name = "size") int size,
                                                               @RequestParam(name = "sort", required = false) String sortBy,
                                                               @RequestParam(name = "order", required = false) Sort.Direction order){
        return ResponseEntity.ok(productService.findAllProducts(page - 1, size, sortBy, order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@PathVariable Long id,
                                                                @RequestBody ProductUpdateRequestDTO dto){
        return ResponseEntity.ok(productService.updateProductById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build(); //204 No-Content
    }
    //Alternatif:
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> deleteProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProductById(id));
    }
    */
}
