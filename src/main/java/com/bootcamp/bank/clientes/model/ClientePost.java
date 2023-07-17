package com.bootcamp.bank.clientes.model;

import lombok.Data;

@Data
public class ClientePost {
    private String id;
    private String tipoCli;
    private String tipoDocumento;
    private String nroDocumento;
    private String nombre;
    private String razonSocial;
    private Double limiteCredito;
}