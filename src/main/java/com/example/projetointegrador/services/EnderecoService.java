package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Endereco;

import java.util.List;

public interface EnderecoService {


    List<Endereco> buscarEndereco();

    Endereco editar(Endereco endereco);

    Endereco salvarEndereco(Endereco endereco) throws Exception;

    void deletar(Long id_endereco);
}
