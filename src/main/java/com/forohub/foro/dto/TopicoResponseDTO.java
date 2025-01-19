package com.forohub.foro.dto;

import jakarta.validation.constraints.NotBlank;


public record TopicoResponseDTO(
        @NotBlank
        String curso,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        Long id_user
) {
}
