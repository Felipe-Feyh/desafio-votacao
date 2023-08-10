<<<<<<< HEAD
package com.db.votacao.api.controller;

import com.db.votacao.api.model.Associado;
import com.db.votacao.api.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associado")
public class AssociadoController {

    private final AssociadoService associadoService;

    @Autowired
    public AssociadoController(AssociadoService associadoService) {
        this.associadoService = associadoService;
    }

    @PostMapping
    public ResponseEntity<Associado> criarAssociado(@RequestBody Associado associadoRequest) {

        Associado associado = associadoService.criarAssociado(associadoRequest);

        if (associado == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(associado, HttpStatus.CREATED);
    }
}