package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Taxa;

import java.util.List;

public interface TaxaService {
    List<Taxa> buscarTaxa();

    Taxa editarTaxa(Taxa taxa);

    Taxa salvarTaxa (Taxa taxa) throws Exception;

    void deletar(Long id_taxa);

}
