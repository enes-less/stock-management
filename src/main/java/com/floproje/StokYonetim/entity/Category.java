package com.floproje.StokYonetim.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    //@JsonIgnore
    private List<Product> products;
}
