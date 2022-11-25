package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.PessoaDTO;
import com.example.projetointegrador.models.Pessoa;
import java.util.List;

public interface PessoaService {
    List<Pessoa> buscarPessoa();

    Pessoa editar(PessoaDTO pessoaDTO);

    Pessoa salvarPessoa (PessoaDTO pessoaDTO) throws Exception;

    void deletar(Long id_pessoa);

    void adicionarTaxa();
}
