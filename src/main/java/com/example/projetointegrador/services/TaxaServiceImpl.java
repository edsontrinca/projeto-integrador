package com.example.projetointegrador.services;
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
    public Taxa editarTaxa(Taxa taxa) {
        return taxaRepository.save(taxa);
    }

    @Override
    public Taxa salvarTaxa (Taxa taxa) throws Exception {
        List<Taxa> listaDeTaxa = taxaRepository.findAll();
        for (Taxa taxa1: listaDeTaxa) {
            if (taxa.getNome().equals(taxa1.getNome())) {
                throw new Exception("Essa Taxa já esta cadastrada!");
            }
        }
        return taxaRepository.save(taxa);
    }

    @Override
    public void deletar(Long id_taxa){
        taxaRepository.deleteById(id_taxa);
    }

}


