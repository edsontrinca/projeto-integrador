package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.EnderecoDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
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
    public Endereco editar(EnderecoDTO enderecoDTO) {

        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numeroCasa(enderecoDTO.getNumeroCasa())
                .referencia(enderecoDTO.getReferencia())
                .cep(enderecoDTO.getCep())
                .bairro(enderecoDTO.getBairro())
                .build();

        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco salvarEndereco(EnderecoDTO enderecoDTO) throws Exception {
        List<Endereco> listaDeEndereco = enderecoRepository.findAll();
        for (Endereco endereco1: listaDeEndereco) {
            if (enderecoDTO.getNumeroCasa().equals(endereco1.getNumeroCasa())) {
                throw new EntityNotFoundException("Esse Número já esta cadastrado!");
            }

        }

        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numeroCasa(enderecoDTO.getNumeroCasa())
                .referencia(enderecoDTO.getReferencia())
                .cep(enderecoDTO.getCep())
                .bairro(enderecoDTO.getBairro())
                .build();



        return enderecoRepository.save(endereco);
    }


    @Override
    public void deletar(Long id_endereco){
        enderecoRepository.deleteById(id_endereco);
    }
}