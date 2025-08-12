package com.floproje.StokYonetim.repository;

import com.floproje.StokYonetim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
