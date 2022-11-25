package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.DocumentoDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.repositories.DocumentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
    public class DocumentoServiceImpl implements com.example.projetointegrador.services.DocumentoService {
        final DocumentoRepository documentoRepository;

        public DocumentoServiceImpl(DocumentoRepository documentoRepository) {

            this.documentoRepository = documentoRepository;
        }

        @Override
        public List<Documento> buscarDocumento() {
            return documentoRepository.findAll();
        }

        @Override
        public Documento editar(DocumentoDTO documentoDTO) {
            Documento documento = Documento.builder()
                    .identidade(documentoDTO.getIdentidade())
                    .cnpj(documentoDTO.getCnpj())
                    .cpf(documentoDTO.getCpf())
                    .build();
//             Pessoa pessoa = Pessoa.builder()
//                .nome(pessoaDTO.getNome())
//                .dependentes(pessoaDTO.getDependentes())
//                .idade(pessoaDTO.getIdade())
//                .estadoCivil(pessoaDTO.getEstadoCivil())
//                .genero(pessoaDTO.getGenero())
//                .rendimentoMensal(pessoaDTO.getRendimentoMensal())
//                .documento(pessoaDTO.getDocumento())
//                .carteira(pessoaDTO.getCarteira())
//                .endereco(pessoaDTO.getEndereco())
//                .taxa(pessoaDTO.getTaxa())
//                .build();
            return documentoRepository.save(documento);
        }


        @Override
        public Documento salvarDocumento(DocumentoDTO documentoDTO) throws Exception {
            List<Documento> listaDeDocumento = documentoRepository.findAll();
            for (Documento documento1: listaDeDocumento) {
                if (documentoDTO.getCpf().equals(documento1.getCpf())) {
                    throw new EntityNotFoundException(" Esse CPF já está cadastrado! ");
                }

                if (documentoDTO.getIdentidade().equals(documento1.getIdentidade())){
                    throw new EntityNotFoundException(" Essa Identidade já está cadastrada! ");
                }

                if (documentoDTO.getCnpj().equals(documento1.getCnpj())){
                    throw new EntityNotFoundException(" Esse CNPJ já está cadastrado! " );
                }
            }

            Documento documento = Documento.builder()
                    .identidade(documentoDTO.getIdentidade())
                    .cnpj(documentoDTO.getCnpj())
                    .cpf(documentoDTO.getCpf())
                    .build();
            return documentoRepository.save(documento);
        }



    @Override
        public void deletar(Long id_documento) {
            documentoRepository.deleteById(id_documento);
        }
    }