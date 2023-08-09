package com.eldar.challenge.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tasas_operaciones")
public class TasaOperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String importe;
}
