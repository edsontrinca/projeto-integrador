package com.example.projetointegrador.services;

import com.example.projetointegrador.models.Carteira;

import java.util.List;

public interface CarteiraService {

    List<Carteira> buscarCarteira();

    Carteira alterarCarteira(Carteira carteira);

    Carteira salvarCarteira(Carteira carteira);


    void deletar(Long id_carteira);
}
