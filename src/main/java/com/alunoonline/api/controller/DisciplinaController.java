package com.alunoonline.api.controller;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.repository.DisciplinaRepository;
import com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService service;



    @GetMapping("/disponiveis")
    public ResponseEntity<List<String>> getCodigoDisciplinasDisponiveis() {
        List<String> listaDisciplinas = service.listarCodigoDisciplinas();

        return ResponseEntity.ok(listaDisciplinas);
    }


    @GetMapping
    public ResponseEntity<List<Disciplina>> getDisciplinas() {
        List<Disciplina> listaDisciplinas = service.listarDisciplinas();

        return ResponseEntity.ok(listaDisciplinas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Disciplina> getDisciplinaByCodigo(@PathVariable String codigo) {
        Disciplina disciplina = service.findDisciplinaByCode(codigo);

        return ResponseEntity.ok(disciplina);
    }

}
