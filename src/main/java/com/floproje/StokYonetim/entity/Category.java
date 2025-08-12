package com.floproje.StokYonetim.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity //! Kategori tablosu olussun
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
