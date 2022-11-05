package com.example.projetointegrador.services;

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
    public Carteira salvarCarteira(Carteira carteira) {
        return carteiraRepository.save(carteira);
    }
}
