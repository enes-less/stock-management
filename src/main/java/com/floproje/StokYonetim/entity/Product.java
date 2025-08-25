package com.floproje.StokYonetim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity //! Bu class'a karsilik gelen bir tablo olusturulacak
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product{

    @Id //! Hemen altindaki field'i Primary Key olarak belirler.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //! ID'ler otomatik olusturulur, 1'den baslar
    private Long id;

    //! Column, sutunu modifiye etmek icin kullanilir.
    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    private Integer initialStock;

    private Integer stock;

    private Integer rop;

    private String sku;

    private Double size;

    private String color;

    private String gender;

    private Double price;

    private Boolean isForKids;

    @ManyToOne
    @JoinColumn(name = "category_id") //! Foreign Key
    private Category category; //Foreign Key sutununun default ismi, field ismi + _id'dir. category_id

}
