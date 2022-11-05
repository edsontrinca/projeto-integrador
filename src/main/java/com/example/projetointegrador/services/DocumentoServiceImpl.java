package com.example.projetointegrador.services;
import com.example.projetointegrador.models.Documento;
import com.example.projetointegrador.repositories.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
public Documento salvarDocumento (Documento documento) {
        return documentoRepository.save(documento);
        }
        }