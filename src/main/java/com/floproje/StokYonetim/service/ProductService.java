package com.floproje.StokYonetim.service;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductResponseDTO;
import com.floproje.StokYonetim.dto.ProductUpdateRequestDTO;
import com.floproje.StokYonetim.entity.Category;
import com.floproje.StokYonetim.entity.Product;
import com.floproje.StokYonetim.exception.EntityNotFoundException;
import com.floproje.StokYonetim.helper.ProductMapper;
import com.floproje.StokYonetim.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductService {
    //Bu islem dependency injection.
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ProductResponseDTO saveProduct(ProductCreateRequestDTO dto) {
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
        return productMapper.mapProductToProductResponseDTO(savedProduct);
    }

    /*
    //Field injection, tavsiye edilmez.
    @Autowired
    private ProductRepository productRepository2;
    */
    //findById, baska hicbir yerde kullanimayacaksa, private yapilabilir.
    private Product findById(Long id) {
        // Optional + orElseThrow kullanılıyor, null check gerek yok
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No product found with given ID: " + id));
    }

    // (productcontroller için findproductbyid metodu)
    public ProductResponseDTO findProductById(Long id){
        return productMapper.mapProductToProductResponseDTO(findById(id));
    }

    public Map<String, Object> findAllProducts(int page, int size, String sortBy, Sort.Direction order) {
        Pageable pageable;

        //Pageable icin verilen bilgiler eksikse yerine manuel olarak id'nin artan sirasina gore urunleri getirdik
        //(default)
        if (sortBy != null && order != null){
             pageable = PageRequest.of(page, size, order, sortBy);
        }else{
            if (sortBy != null){
                pageable = PageRequest.of(page, size, Sort.Direction.ASC, sortBy);
            }else if(order != null){
                pageable = PageRequest.of(page, size, order, "id");
            }else{
                pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
            }
        }

        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductResponseDTO> productList = productPage
                .stream().map(productMapper::mapProductToProductResponseDTO).toList();

        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", pageable.getPageNumber() + 1);
        map.put("totalPages", productPage.getTotalPages());
        map.put("productCount", productPage.getNumberOfElements());
        map.put("totalProducts", productPage.getTotalElements());
        map.put("products", productList);

        return map;
    }

    public ProductResponseDTO updateProductById(Long id, ProductUpdateRequestDTO dto) {
        Product foundProduct = findById(id); //Hibernate Entity LifeCycle: Bu obje bulunursa, hibernate tarafindan
        //takibe alinacak.

        //kategoriyi burada bulup mapper'a gonderebilirim.
        Category category = categoryService.findByName(dto.getCategory().getName());

        Product toBeUpdated = productMapper.mapProductUpdateRequestDTOToUpadtedProduct(foundProduct, dto, category);

        Product updatedProduct = productRepository.save(toBeUpdated);

        return productMapper.mapProductToProductResponseDTO(updatedProduct);
    }

    public void deleteProductById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
    }

    //Alternatif:
    /*
    public ProductResponseDTO deleteProductById(Long id) {
        Product product = findById(id);
        productRepository.delete(product);
        return productMapper.mapProductToProductResponseDTO(product);
    }
    */
}
