package com.amil.e_comerce_backend.DTO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class productDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false, length = (100))
    private String name;

    @Column(name = "VALUE", nullable = false, length = (100))
    private double value;

    @Column(name = "RESALE", nullable = false, length = (100))
    private double resaleValue;

    @Column(name = "DESCRIPITION", nullable = false, length = (300))
    private String descripition;

    // LIGACOES //
    // ManyToMany whith Customer = Sale/Cart
    // ManyToMany whith Customer = Favorites
    // ManyToMany whith Tags = TagsProducts
    // ManyToMany whith Category = CategoryProduct
}
