package com.tunja.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class ClientEntity {

    @Id
    @Column(name = "id")
    private String idClient;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String last_name;

    @Column(name = "celular")
    private String phone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String mail;

}
