package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductCreateResponseDTO;
import com.floproje.StokYonetim.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    //Bu islem dependency injection.
    private final ProductRepository productRepository;

    public ProductCreateResponseDTO saveProduct(ProductCreateRequestDTO dto) {
        //Buradan devam edilecek...
        return null;
    }

    /*
    //Field injection, tavsiye edilmez.
    @Autowired
    private ProductRepository productRepository2;
    */
}
