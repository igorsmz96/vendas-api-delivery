package com.vendas.api.delivery_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cnpj;
    private String phone;
    @Column(nullable = false)
    private Boolean active = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}
