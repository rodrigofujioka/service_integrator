package com.posback.api.controller;

import com.posback.api.model.Esporte;
import com.posback.api.service.EsporteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/esporte")
public class EsporteController {


    private EsporteService service;



    @GetMapping("/disponiveis")
    public ResponseEntity<List<String>> getCodigoEsportesDisponiveis() {
        List<String> listaDisciplinas = service.listarCodigoEsportes();

        return ResponseEntity.ok(listaDisciplinas);
    }


    @GetMapping
    public ResponseEntity<List<Esporte>> getEsportes() {
        List<Esporte> listaDisciplinas = service.listarEsportes();

        return ResponseEntity.ok(listaDisciplinas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Esporte> getEsporteByCodigo(@PathVariable String codigo) {
        Esporte disciplina = service.findEsporteByCode(codigo);

        return ResponseEntity.ok(disciplina);
    }

}
