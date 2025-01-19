package com.forohub.foro.controller;

import com.forohub.foro.dto.TopicoCreateDTO;
import com.forohub.foro.dto.TopicoResponseDTO;
import com.forohub.foro.dto.TopicoUpdateDTO;
import com.forohub.foro.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @GetMapping
    @Transactional
    public ResponseEntity getAllTopicos(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        Page<TopicoResponseDTO> topicos = topicoService.findAll(pageable);
        return ResponseEntity.ok().body(topicos);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponseDTO> createTopico(@RequestBody @Valid TopicoCreateDTO topicoCreateDTO) {
        TopicoResponseDTO topico = topicoService.save(topicoCreateDTO);
        return ResponseEntity.created(URI.create("/api/topicos")).body(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopico(@PathVariable Long id) {
        topicoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopico(@RequestBody @Valid TopicoUpdateDTO topicoUpdateDTO) {
        topicoService.update(topicoUpdateDTO);
        return ResponseEntity.ok().build();
    }
}
