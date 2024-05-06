package com.crudapirest.serviceImpl;

import java.util.List;
import java.util.Optional;
import com.crudapirest.repository.CandidateRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudapirest.model.Candidate;
import com.crudapirest.service.InterfaceService01;

@Slf4j
@Service
public class Service01Impl implements InterfaceService01 {

    @Autowired(required = false)
    private CandidateRepo repo;

    @Override
    public List<Candidate> listar() {
        return repo.findAll();
    }

    @Override
    public Candidate registrar(Candidate t) {
        return repo.save(t);
    }

    @Override
    public Optional<Candidate> obtenerPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Candidate modificar(Candidate t) {
        return repo.save(t);
    }


    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }

}
