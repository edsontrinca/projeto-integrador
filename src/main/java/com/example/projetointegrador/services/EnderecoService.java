package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.EnderecoDTO;
import com.example.projetointegrador.models.Endereco;
import java.util.List;

public interface EnderecoService {


    List<Endereco> buscarEndereco();

    Endereco editar(EnderecoDTO enderecoDTO);

    Endereco salvarEndereco(EnderecoDTO enderecoDTO) throws Exception;

    void deletar(Long id_endereco);
}
