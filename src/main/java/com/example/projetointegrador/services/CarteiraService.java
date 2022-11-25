package com.example.projetointegrador.services;
import com.example.projetointegrador.dto.CarteiraDTO;
import com.example.projetointegrador.models.Carteira;
import java.util.List;

public interface CarteiraService {

    List<Carteira> buscarCarteira();

    Carteira alterarCarteira(CarteiraDTO carteiraDTO);

    Carteira salvarCarteira(CarteiraDTO carteiraDTO) throws Exception;


    void deletar(Long id_carteira);
}
