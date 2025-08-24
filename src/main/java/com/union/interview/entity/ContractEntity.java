package com.union.interview.entity;

import com.union.interview.domain.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity 
@Table(name = "contracts")
@Getter 
@Setter 
@NoArgsConstructor
@RequiredArgsConstructor
public class ContractEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="provider_id")
    private ProviderEntity provider;

    @NonNull
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="service_id")
    private ServiceEntity service;

    @NonNull
    @Column(nullable=false)
    private Integer quantity;

    @NonNull
    @Column(name="total_price", nullable=false, precision=10, scale=2)
    private BigDecimal totalPrice;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private Status status;

}
