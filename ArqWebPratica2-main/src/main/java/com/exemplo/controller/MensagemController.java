package com.exemplo.controller;

import com.exemplo.model.Mensagem;
import com.exemplo.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {
    private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Mensagem> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mensagem> criar(@RequestBody Mensagem m) {
        Mensagem criado = service.criar(m);
        return ResponseEntity.created(URI.create("/mensagens/" + criado.getId())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mensagem> atualizar(@PathVariable Long id, @RequestBody Mensagem m) {
        try {
            Mensagem updated = service.atualizar(id, m);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
