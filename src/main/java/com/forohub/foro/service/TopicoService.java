package com.forohub.foro.service;

import com.forohub.foro.dto.TopicoCreateDTO;
import com.forohub.foro.dto.TopicoResponseDTO;
import com.forohub.foro.dto.TopicoUpdateDTO;
import com.forohub.foro.mapper.TopicoMapper;
import com.forohub.foro.model.Topico;
import com.forohub.foro.repository.TopicoRepository;
import com.forohub.foro.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Optional;

@Service
public class TopicoService {

    private TopicoRepository repo;
    private UserRepository userRepo;
    private TopicoMapper mapper;

    public TopicoService(TopicoRepository repo, UserRepository userRepo, TopicoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
        this.userRepo = userRepo;
    }

    public Page<TopicoResponseDTO> findAll(Pageable pageable) {

         Page<Topico> topicos = repo.findAllByStatusTrue(pageable);

        return topicos.map(mapper::toDto);
    }

    public TopicoResponseDTO findById(Long id) {
        Optional<Topico> obj = repo.findById(id);
        return obj.map(topico -> mapper.toDto(topico)).orElse(null);
    }

    public TopicoResponseDTO save(TopicoCreateDTO obj) {

        Topico topico = mapper.toEntity(obj);
        topico.setStatus(true);
        topico.setFecha(LocalDate.now());
        userRepo.findById(obj.user_id()).ifPresent(u -> topico.setUser(u));

        repo.save(topico);

        return mapper.toDto(topico);
    }

    public void delete(Long id) {
        Topico topico = repo.getReferenceById(id);
        desactivarStatus(topico);

    }

    public TopicoResponseDTO update(TopicoUpdateDTO obj) {
        Topico topico = repo.getReferenceById(obj.id());

        actualizarDatos(topico, obj);

        return mapper.toDto(topico);
    }

    private void actualizarDatos(Topico topico, TopicoUpdateDTO obj) {
        if (obj.titulo() != null) {
            topico.setTitulo(obj.titulo());
        }
        if (obj.curso() != null) {
            topico.setCurso(obj.curso());
        }
        if (obj.mensaje() != null) {
            topico.setMensaje(obj.mensaje());
        }
        if (obj.status() != null) {
            topico.setStatus(obj.status());
        }
    }

    private void desactivarStatus(Topico topico) {
        topico.setStatus(false);
    }
}
