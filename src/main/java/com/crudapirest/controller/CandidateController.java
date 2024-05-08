package com.crudapirest.controller;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudapirest.service.InterfaceService01;
import com.crudapirest.model.Candidate;

@Slf4j
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private InterfaceService01 service;

    @GetMapping("/listar")
    public List<Candidate> listar() {
        return service.listar();
    }

    @PostMapping("/registrar")
    public Candidate registrar(@RequestBody Candidate candidate) {
        return service.registrar(candidate);
    }

    @GetMapping("/obtenerPorId/{id}")
    public Optional<Candidate> obtenerPorId(@PathVariable("id") int id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/modificar")
    public Candidate modificar(@RequestBody Candidate candidate) {
        return service.modificar(candidate);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
    }

}
