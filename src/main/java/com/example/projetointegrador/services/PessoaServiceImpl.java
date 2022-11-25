package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.PessoaDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
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
    public Pessoa editar(PessoaDTO pessoaDTO) {

            Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .dependentes(pessoaDTO.getDependentes())
                .idade(pessoaDTO.getIdade())
                .estadoCivil(pessoaDTO.getEstadoCivil())
                .genero(pessoaDTO.getGenero())
                .rendimentoMensal(pessoaDTO.getRendimentoMensal())
                .documento(pessoaDTO.getDocumento())
                .carteira(pessoaDTO.getCarteira())
                .endereco(pessoaDTO.getEndereco())
                .taxa(pessoaDTO.getTaxa())
                .build();
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa salvarPessoa (PessoaDTO pessoaDTO) throws Exception {
        List<Pessoa> listaDePessoa = pessoaRepository.findAll();
        for (Pessoa informacaoPessoa: listaDePessoa) {
            if (pessoaDTO.getNome().equals(informacaoPessoa.getNome())) {
                throw new EntityNotFoundException("Esse nome já esta cadastrado!");
            }
            if(pessoaDTO.getDocumento().getCpf().equals(informacaoPessoa.getDocumento().getCpf())) {
                throw new EntityNotFoundException(" Estes CPF já esta cadastrado, tente outro! ");
            }

            if (pessoaDTO.getDocumento().getIdentidade().equals(informacaoPessoa.getDocumento().getIdentidade())){
                throw new EntityNotFoundException(" Essa identidade já está cadastrada, tente outra! ");
            }

            if (pessoaDTO.getEndereco().getNumeroCasa().equals(informacaoPessoa.getEndereco().getNumeroCasa())){
                throw new EntityNotFoundException(" Esse número já está cadastrado, tente outro! ");
            }


       }

        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .dependentes(pessoaDTO.getDependentes())
                .idade(pessoaDTO.getIdade())
                .estadoCivil(pessoaDTO.getEstadoCivil())
                .genero(pessoaDTO.getGenero())
                .rendimentoMensal(pessoaDTO.getRendimentoMensal())
                .documento(pessoaDTO.getDocumento())
                .carteira(pessoaDTO.getCarteira())
                .endereco(pessoaDTO.getEndereco())
                .taxa(pessoaDTO.getTaxa())
                .build();

       return pessoaRepository.save(pessoa);
    }

    @Override
    public void deletar(Long id_pessoa){
        pessoaRepository.deleteById(id_pessoa);
    }

    @Override
    public void adicionarTaxa(){
        List<Pessoa> taxaList = pessoaRepository.findAll();
        for (Pessoa pessoa2 : taxaList) {
            if(pessoa2.getCarteira().getSaldoAtual() != null && pessoa2.getTaxa() != null && pessoa2.getTaxa().getPorcentagem() != null) {
                Double saldoAtual = pessoa2.getCarteira().getSaldoAtual();
                Double juros = pessoa2.getTaxa().getPorcentagem();
                Double rendimento = saldoAtual + (saldoAtual*(juros/100));
                pessoa2.getCarteira().setSaldoAtual(rendimento);
            }
        }
    }


}
