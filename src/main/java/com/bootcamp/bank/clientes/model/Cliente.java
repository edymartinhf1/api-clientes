package com.bootcamp.bank.clientes.model;

import lombok.Data;

@Data
public class Cliente {
    private String id;
    private String tipoCli;
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String razonSocial;
    private String numeroCelular;
    private String imeiCelular;
    private String correo;
    private Double limiteCredito;



}
