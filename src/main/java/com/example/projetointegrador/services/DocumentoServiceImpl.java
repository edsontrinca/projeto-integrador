package com.example.projetointegrador.services;
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
        public Documento editar(Documento documento) {
            return documentoRepository.save(documento);
        }


        @Override
        public Documento salvarDocumento(Documento documento) throws Exception {
            List<Documento> listaDeDocumento = documentoRepository.findAll();
            for (Documento documento1: listaDeDocumento) {
                if (Objects.equals(documento.getCpf(),documento.getCnpj().equals(documento1.getCnpj()))) {
                    throw new Exception("Esse documento já esta cadastrado!");
                }
            }
            return documentoRepository.save(documento);
        }


        @Override
        public void deletar(Long id_documento) {
            documentoRepository.deleteById(id_documento);
        }
    }