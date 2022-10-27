package com.example.projetointegrador.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Taxa")
public class Taxa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Porcentagem")
    private Double porcentagem;

}
