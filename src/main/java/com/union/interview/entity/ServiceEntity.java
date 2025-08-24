package com.union.interview.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity 
@Table(name = "services")
@Getter 
@Setter 
@NoArgsConstructor
public class ServiceEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String code;

    @Column(nullable=false)
    private String name;

    @Column(name="unit_price", nullable=false, precision=10, scale=2)
    private BigDecimal unitPrice;
}
