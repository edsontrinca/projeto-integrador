package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Documento;

import java.util.List;

public interface DocumentoService {

    List<Documento> buscarDocumento();

    Documento editar (Documento documento);

    Documento salvarDocumento (Documento documento);

    void deletar(Long id_documento);
}
