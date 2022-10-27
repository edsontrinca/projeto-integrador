package com.example.projetointegrador.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// o @ significa que é uma anotation
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Nome")
    private String nome;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "documento_pessoa",
    joinColumns = @JoinColumn(name = "id_documento"),
    inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Documento documento;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "pessoa_endereco",
            joinColumns = @JoinColumn(name = "id_endereco"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Endereco endereco;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Idade")
    private Integer idade;
    @Column(name = "Rendimento Mensal")
    private Double rendimentoMensal;
    @Column(name = "Estado Civil")
    private String estadoCivil;
    @Column(name = "Dependentes")
    private String dependentes;


    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "pessoa_carteira",
            joinColumns = @JoinColumn(name = "id_carteira"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Carteira carteira;


}
