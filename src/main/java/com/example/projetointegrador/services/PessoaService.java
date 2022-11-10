package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Pessoa;

import java.util.List;

public interface PessoaService {
    List<Pessoa> buscarPessoa();

    Pessoa editar(Pessoa pessoa);

    Pessoa salvarPessoa (Pessoa pessoa) throws Exception;

    void deletar(Long id_pessoa);
}
