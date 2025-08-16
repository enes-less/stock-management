package com.floproje.StokYonetim.helper;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductCreateResponseDTO;
import com.floproje.StokYonetim.entity.Product;
import org.springframework.stereotype.Component;

@Component //Spring Boot, otomatik olarak bu classtan bir obje turetir ve kullanir.
//Yani bir bean uretir.
public class ProductMapper {

    //ProductCreateRequestDTO -> Product
    public Product mapProductCreateRequestDTOToProduct(ProductCreateRequestDTO dto){
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setStock(dto.getStock());
        product.setSize(dto.getSize());
        product.setColor(dto.getColor());
        product.setGender(dto.getGender());
        product.setPrice(dto.getPrice());
        product.setIsForKids(dto.getIsForKids());

        return product;
    }

    //Product -> ProductCreateResponseDTO
    public ProductCreateResponseDTO mapProductToProductCreateResponseDTO(Product product){
        ProductCreateResponseDTO dto = new ProductCreateResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setStock(product.getStock());
        dto.setSize(product.getSize());
        dto.setColor(product.getColor());
        dto.setGender(product.getGender());
        dto.setPrice(product.getPrice());
        dto.setIsForKids(product.getIsForKids());
        dto.setCategory(product.getCategory());

        return dto;
    }
}
