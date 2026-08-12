package com.vendas.api.delivery_api.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;

    private Double longitude;
    private Double latitude;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")

    private User user;





}
