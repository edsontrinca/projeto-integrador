package com.example.projetointegrador.dto;

import lombok.Data;

import java.util.Date;

public class CarteiraDTO {

    @Data
    public class Carteira {

        private Long id;
        private String nome;
        private Double saldoAtual;
        private Date dataInicioInvestimento;
        private Date dataTerminoInvestimento;
    }
}
