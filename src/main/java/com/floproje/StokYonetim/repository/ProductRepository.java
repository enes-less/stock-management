package com.floproje.StokYonetim.repository;

import com.floproje.StokYonetim.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    @Query("SELECT SUM(p.stock) FROM Product p")
    Long getTotalStock();

    @Query("SELECT p FROM Product p WHERE p.stock <= (p.rop * p.initialStock / 100)")
    List<Product> findLowStockProducts();
}
