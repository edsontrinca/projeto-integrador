package com.example.projetointegrador.services;
import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaServiceImpl implements com.example.projetointegrador.services.PessoaService {
    final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {

        this.pessoaRepository = pessoaRepository;
    }
    @Override
    public List<Pessoa> buscarPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa editar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa salvarPessoa (Pessoa pessoa) throws Exception {
        List<Pessoa> listaDePessoa = pessoaRepository.findAll();
        for (Pessoa pessoa1: listaDePessoa) {
            if (pessoa.getNome().equals(pessoa1.getNome())) {
                throw new Exception("Esse nome já esta cadastrado!");
            }
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public void deletar(Long id_pessoa){
        pessoaRepository.deleteById(id_pessoa);
    }
}
