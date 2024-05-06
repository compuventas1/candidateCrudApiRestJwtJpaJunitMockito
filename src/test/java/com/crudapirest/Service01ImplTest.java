package com.crudapirest;

import com.crudapirest.model.Candidate;
import com.crudapirest.repository.CandidateRepo;
import com.crudapirest.serviceImpl.Service01Impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

class Service01ImplTest {


    @Mock
    private CandidateRepo candidateRepo;

    @InjectMocks
    private Service01Impl service01;

    private Candidate candidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        candidate = new Candidate();
        candidate.setId(7);
        candidate.setName("Jorge Ramiro");
        candidate.setEmail("jramiro@gmail.com");
        candidate.setGender("Masculino");
        candidate.setSalaryExpected("3100");
    }

    @Test
    void listar() throws Exception {
        when(candidateRepo.findAll()).thenReturn(Arrays.asList(candidate));
        assertNotNull(service01.listar());
    }

    @Test
    void registrar() throws Exception {
        when(candidateRepo.save(any(Candidate.class))).thenReturn(candidate);
        assertNotNull(service01.registrar(new Candidate()));
    }

    @Test
    void obtenerPorId() throws Exception {
        when(candidateRepo.findById(7)).thenReturn(Optional.ofNullable(candidate));
        assertNotNull(service01.obtenerPorId(7));
    }

    @Test
    void modificar() throws Exception {
        when(candidateRepo.save(any(Candidate.class))).thenReturn(candidate);
        assertNotNull(service01.modificar(new Candidate()));
    }

    @Test
    void eliminar() throws Exception {
        when(candidateRepo.findById(7)).thenReturn(Optional.ofNullable(candidate));
        doNothing().when(candidateRepo).delete(candidate);

        service01.eliminar(7);
        assertAll(() -> service01.eliminar(7));
    }
}