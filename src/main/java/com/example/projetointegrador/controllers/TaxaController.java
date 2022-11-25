package com.example.projetointegrador.controllers;
import com.example.projetointegrador.dto.TaxaDTO;
import com.example.projetointegrador.models.Taxa;
import com.example.projetointegrador.services.TaxaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api")
@CrossOrigin

public class TaxaController {

    final TaxaServiceImpl taxaServiceImpl;

    public TaxaController(TaxaServiceImpl taxaService) throws Exception{
        this.taxaServiceImpl = taxaService;
    }
    @PostMapping(value = "/salvarTaxa")
    public ResponseEntity<Object>salvarTaxa(@RequestBody TaxaDTO taxaDTO) throws Exception {
        Taxa response = taxaServiceImpl.salvarTaxa(taxaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping(value = "/buscarTaxa")
    public ResponseEntity<Object>buscarTaxa() {
        List<Taxa> response = taxaServiceImpl.buscarTaxa();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping(value = "/editarTaxa")
    public ResponseEntity<Object> editarTaxa(@RequestBody TaxaDTO taxa) {
        Taxa response = taxaServiceImpl.editarTaxa(taxa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping(value = "/deletarTaxa")
    public ResponseEntity<Object> deletarTaxa(Long id_taxa){
        taxaServiceImpl.deletar(id_taxa);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}




