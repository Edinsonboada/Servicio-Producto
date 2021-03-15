package com.boada.unmsm.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String partNumber;

    @NotEmpty
    private String tipoProducto;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String imagen;

    @Min(0)
    @NotNull
    private int cantidadComponentes;
}
