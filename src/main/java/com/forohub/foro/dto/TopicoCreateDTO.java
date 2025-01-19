package com.forohub.foro.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TopicoCreateDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @JsonAlias({"user_id", "id_user"})
        Long user_id,
        @NotBlank
        String curso

) {
}
