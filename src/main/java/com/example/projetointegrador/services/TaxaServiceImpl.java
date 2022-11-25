package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.TaxaDTO;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.repositories.TaxaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaxaServiceImpl implements com.example.projetointegrador.services.TaxaService {

    final TaxaRepository taxaRepository;

    public TaxaServiceImpl (TaxaRepository taxaRepository) {
        this.taxaRepository = taxaRepository;

    }

    @Override
    public List<Taxa> buscarTaxa() {
        return taxaRepository.findAll();
    }

    @Override
    public Taxa editarTaxa(TaxaDTO taxaDTO) {
        Taxa taxa= Taxa.builder()
                .nome(taxaDTO.getNome())
                .porcentagem(taxaDTO.getPorcentagem() != null ? taxaDTO.getPorcentagem() : null)
                .build();

        return taxaRepository.save(taxa);
    }

    @Override
    public Taxa salvarTaxa (TaxaDTO taxaDTO) throws Exception {
        List<Taxa> listaDeTaxa = taxaRepository.findAll();
        for (Taxa infoTaxa: listaDeTaxa) {

            if (taxaDTO.getNome().equals(infoTaxa.getNome())) {
                throw new EntityNotFoundException("Essa Taxa já está cadastrada!");
            }
            if (taxaDTO.getPorcentagem().equals(infoTaxa.getPorcentagem())){
                throw new EntityNotFoundException("Essa porcentagem já está cadastrada! ");
            }

        }
        Taxa taxa = Taxa.builder()
                .nome(taxaDTO.getNome())
                .porcentagem(taxaDTO.getPorcentagem() != null ? taxaDTO.getPorcentagem() : null)
                .build();

        return taxaRepository.save(taxa);
    }


    @Override
    public void deletar(Long id_taxa){
        taxaRepository.deleteById(id_taxa);
    }

}


