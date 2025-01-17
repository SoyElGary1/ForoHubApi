package com.forohub.foro.service;

import com.forohub.foro.model.Topico;
import com.forohub.foro.repository.TopicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private TopicoRepository repo;

    public TopicoService(TopicoRepository repo) {
        this.repo = repo;
    }

    public List<Topico> findAll() {
        return repo.findAll();
    }

    public Topico findById(Long id) {
        Optional<Topico> obj = repo.findById(id);

        return obj.orElse(null);
    }

    public Topico save(Topico obj) {
        return repo.save(obj);
    }

    public void delete(Long id) {
        Optional<Topico> obj = repo.findById(id);
        obj.ifPresent(topico -> repo.delete(topico));
    }

    public Topico update(Topico obj) {
        return repo.save(obj);
    }
}
