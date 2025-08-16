package com.floproje.StokYonetim.repository;

import com.floproje.StokYonetim.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name); //findBy bir keyword. Arkasina ilk harfi buyuk olmak uzere field
    // isimlerini ekleyerek, method derivation yapilir. Yani query yazmadan metod otomatik olarak anlasilir ve uygun
    // veritabani islemi yapilir.
}
