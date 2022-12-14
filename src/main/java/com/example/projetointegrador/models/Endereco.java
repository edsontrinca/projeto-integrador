package com.example.projetointegrador.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "endereco")
public class Endereco {

    @Id //id da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id_endereco;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numeroCasa")
    private String numeroCasa;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

}
