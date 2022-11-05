package com.example.projetointegrador.controllers;

import com.example.projetointegrador.dto.EnderecoDTO;
import com.example.projetointegrador.models.Endereco;
import com.example.projetointegrador.models.Pessoa;
import com.example.projetointegrador.services.EnderecoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class EnderecoController {
    final EnderecoServiceImpl enderecoServiceImpl;

    public EnderecoController(EnderecoServiceImpl enderecoService) {

        this.enderecoServiceImpl = enderecoService;
    }
    @PostMapping(value = "/salvarEndereco")
    public ResponseEntity<Object>salvarEndereco(@RequestBody Endereco endereco){
        Endereco response = enderecoServiceImpl.salvarEndereco(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/buscarEndereco")
    public ResponseEntity<Object> buscarEndereco() {
        List<Endereco> response = enderecoServiceImpl.buscarEndereco();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/editarEndereco")
    public ResponseEntity<Object> editarEndereco(@RequestBody Endereco endereco) {
        Endereco response = enderecoServiceImpl.editar(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}