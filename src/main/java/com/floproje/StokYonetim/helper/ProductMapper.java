package com.floproje.StokYonetim.helper;

import com.floproje.StokYonetim.dto.ProductCreateRequestDTO;
import com.floproje.StokYonetim.dto.ProductResponseDTO;
import com.floproje.StokYonetim.dto.ProductUpdateRequestDTO;
import com.floproje.StokYonetim.entity.Category;
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
        product.setInitialStock(dto.getStock());
        product.setRop(dto.getRop());
        product.setSku(dto.getSku());
        product.setStock(dto.getStock());
        product.setSize(dto.getSize());
        product.setColor(dto.getColor());
        product.setGender(dto.getGender());
        product.setPrice(dto.getPrice());
        product.setIsForKids(dto.getIsForKids());

        return product;
    }

    //Product -> ProductResponseDTO
    public ProductResponseDTO mapProductToProductResponseDTO(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setInitialStock(product.getInitialStock());
        dto.setStock(product.getStock());
        dto.setRop(product.getRop());
        dto.setSku(product.getSku());
        dto.setSize(product.getSize());
        dto.setColor(product.getColor());
        dto.setGender(product.getGender());
        dto.setPrice(product.getPrice());
        dto.setIsForKids(product.getIsForKids());
        dto.setCategory(product.getCategory());

        return dto;
    }

    //ProductUpdateRequestDTO -> Product / Replace fields
    public Product mapProductUpdateRequestDTOToUpadtedProduct(Product toBeUpdated,
                                                              ProductUpdateRequestDTO dto,
                                                              Category foundCategory){
        toBeUpdated.setName(dto.getName());
        toBeUpdated.setDescription(dto.getDescription());
        toBeUpdated.setStock(dto.getStock());
        toBeUpdated.setRop(dto.getRop());
        toBeUpdated.setSku(dto.getSku());
        toBeUpdated.setSize(dto.getSize());
        toBeUpdated.setColor(dto.getColor());
        toBeUpdated.setGender(dto.getGender());
        toBeUpdated.setPrice(dto.getPrice());
        toBeUpdated.setIsForKids(dto.getIsForKids());
        //KATEGORI ICIN NE YAPACAGIZ???
        //toBeUpdated.setCategory(dto.getCategory());
        toBeUpdated.setCategory(foundCategory);

        return toBeUpdated;
    }
}
