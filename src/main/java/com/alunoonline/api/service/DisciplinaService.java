package com.alunoonline.api.service;

import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina findDisciplinaByCode(String codigoDisciplina) {
        return repository.findByCodigo(codigoDisciplina);
    }

    public List<String>listarCodigoDisciplinas(){
        return repository.listarCodigoDisciplina();
    }


    @Cacheable("disciplinas")
    public List<Disciplina> listarDisciplinas(){
        return repository.findAll();
    }

}
