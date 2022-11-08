package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Endereco;
import com.example.projetointegrador.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EnderecoServiceImpl implements com.example.projetointegrador.services.EnderecoService {
    final EnderecoRepository enderecoRepository;

    public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {

        this.enderecoRepository = enderecoRepository;
    }
    @Override
    public List<Endereco> buscarEndereco() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco editar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco salvarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletar(Long id_endereco){
        enderecoRepository.deleteById(id_endereco);
    }
}