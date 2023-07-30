package com.bootcamp.bank.clientes.model.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("clientes")
public class ClienteDao {
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