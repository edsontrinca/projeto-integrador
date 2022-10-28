package com.example.projetointegrador.dto;

import lombok.Data;

public class EnderecoDTO {

    @Data

    public class Endereco {
        private String logradouro;
        private String numeroCasa;
        private String referencia;
    }
}