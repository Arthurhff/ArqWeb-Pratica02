package com.exemplo.service;

import com.exemplo.model.Mensagem;
import com.exemplo.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {
    private final MensagemRepository repo;

    public MensagemService(MensagemRepository repo) {
        this.repo = repo;
    }

    public List<Mensagem> listar() { return repo.findAll(); }
    public Optional<Mensagem> buscarPorId(Long id) { return repo.findById(id); }
    public Mensagem criar(Mensagem m) { return repo.save(m); }
    public Mensagem atualizar(Long id, Mensagem m) {
        return repo.findById(id).map(existing -> {
            existing.setTexto(m.getTexto());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Mensagem não encontrada"));
    }
    public void deletar(Long id) { repo.deleteById(id); }
}
