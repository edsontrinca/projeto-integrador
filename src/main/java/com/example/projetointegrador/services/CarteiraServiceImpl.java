package com.example.projetointegrador.services;
import com.example.projetointegrador.exceptions.EntityNotFoundException;
import com.example.projetointegrador.models.Carteira;
import com.example.projetointegrador.repositories.CarteiraRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarteiraServiceImpl implements CarteiraService {
    final CarteiraRepository carteiraRepository;

    public CarteiraServiceImpl (CarteiraRepository carteiraRepository){
        this.carteiraRepository = carteiraRepository;
    }

    @Override

    public List<Carteira> buscarCarteira() {
        return carteiraRepository.findAll();
    }

    @Override

    public Carteira alterarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }

    @Override
    public Carteira salvarCarteira(Carteira carteira) throws Exception {
        List<Carteira> listaDeCarteira = carteiraRepository.findAll();
        for (Carteira carteira1: listaDeCarteira) {
            if (carteira.getNome().equals(carteira1.getNome())) {
                throw new EntityNotFoundException("Esse nome já esta cadastrado!");
            }
        }
        return carteiraRepository.save(carteira);
    }

    @Override
    public void deletar(Long id_carteira) {
        carteiraRepository.deleteById(id_carteira);
    }


}
