package com.example.projetointegrador.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @Column(name = "id_pessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "documento_pessoa",
    joinColumns = @JoinColumn(name = "id_documento"),
    inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Documento documento;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "endereco_pessoa",
            joinColumns = @JoinColumn(name = "id_endereco"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Endereco endereco;

    @Column(name = "genero")
    private String genero;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "rendimentoMensal")
    private Double rendimentoMensal;

    @Column(name = "estadoCivil")
    private String estadoCivil;

    @Column(name = "dependentes")
    private String dependentes;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "carteira_pessoa",
            joinColumns = @JoinColumn(name = "id_carteira"),
            inverseJoinColumns = @JoinColumn(name = "id_pessoa"))
    private Carteira carteira;


}
