package com.vendas.api.delivery_api.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany (mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Address> addresses = new ArrayList <>();



}
