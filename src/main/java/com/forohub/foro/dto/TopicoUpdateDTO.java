package com.forohub.foro.dto;

import jakarta.validation.constraints.NotNull;

public record TopicoUpdateDTO(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        Boolean status,
        String curso
) {

}
