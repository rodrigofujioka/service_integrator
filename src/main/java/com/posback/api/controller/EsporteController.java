package com.posback.api.controller;

import com.posback.api.model.Esporte;
import com.posback.api.service.EsporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/esporte")
public class EsporteController {

    @Autowired
    EsporteService service;



    @GetMapping("/disponiveis")
    public ResponseEntity<List<String>> getCodigoDisciplinasDisponiveis() {
        List<String> listaDisciplinas = service.listarCodigoDisciplinas();

        return ResponseEntity.ok(listaDisciplinas);
    }


    @GetMapping
    public ResponseEntity<List<Esporte>> getDisciplinas() {
        List<Esporte> listaDisciplinas = service.listarDisciplinas();

        return ResponseEntity.ok(listaDisciplinas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Esporte> getDisciplinaByCodigo(@PathVariable String codigo) {
        Esporte disciplina = service.findDisciplinaByCode(codigo);

        return ResponseEntity.ok(disciplina);
    }

}
