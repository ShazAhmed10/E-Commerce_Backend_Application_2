package org.ecommerce_backend.ecommerce_backend_application_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends BaseEntity{
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Category category;

    private String brand;
    private boolean popular;
}
