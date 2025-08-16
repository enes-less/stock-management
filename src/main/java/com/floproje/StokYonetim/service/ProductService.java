package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductCreateResponseDTO;
import com.floproje.StokYonetim.entity.Category;
import com.floproje.StokYonetim.entity.Product;
import com.floproje.StokYonetim.helper.ProductMapper;
import com.floproje.StokYonetim.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    //Bu islem dependency injection.
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ProductCreateResponseDTO saveProduct(ProductCreateRequestDTO dto) {
        //DTO, Product'a donusturulmeli. Mapping
        Product product = productMapper.mapProductCreateRequestDTOToProduct(dto);
        //mapping tamam, product hazir

        //dto icindeki category ismi ile eslesen bir category bulmak
        Category category = categoryService.findByName(dto.getCategory().getName());

        //bulunan category'i product'a vermek
        product.setCategory(category);

        //!save metodu S tipi (bu durumda Product) dondurecek.
        Product savedProduct = productRepository.save(product);

        //Product'i tekrar Response DTO'ya donusturmem lazim
        return productMapper.mapProductToProductCreateResponseDTO(savedProduct);
    }

    /*
    //Field injection, tavsiye edilmez.
    @Autowired
    private ProductRepository productRepository2;
    */
}
