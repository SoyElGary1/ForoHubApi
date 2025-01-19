package com.forohub.foro.mapper;

import com.forohub.foro.dto.TopicoCreateDTO;
import com.forohub.foro.dto.TopicoResponseDTO;
import com.forohub.foro.model.Topico;
import org.springframework.stereotype.Component;

@Component
public class TopicoMapper {

    public TopicoResponseDTO toDto(Topico topico) {

        if (topico == null) {
            return null;
        }

        return new TopicoResponseDTO(
                topico.getCurso(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUser().getId()
        );
    }

    public Topico toEntity(TopicoCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        return new Topico(
                dto.titulo(),
                dto.mensaje(),
                dto.curso()

        );
    }

}
