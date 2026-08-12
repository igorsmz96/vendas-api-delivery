package com.vendas.api.delivery_api.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Product> products = new ArrayList<>();
}