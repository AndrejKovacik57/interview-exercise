package com.union.interview.entity;

import com.union.interview.domain.Status;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "providers")
@Getter 
@Setter 
@NoArgsConstructor
public class ProviderEntity {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true, length=8)
    private String ico;

    @Column(nullable=false)
    private String name;


    @Column(nullable=false)
    private String providerType;

   @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private Status status;
}
