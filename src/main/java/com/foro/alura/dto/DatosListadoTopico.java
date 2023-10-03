package com.foro.alura.dto;

import com.foro.alura.topico.StatusTopico;
import com.foro.alura.topico.Topico;

public record DatosListadoTopico(Long id,
                                 String titulo,
                                 String mensaje,
                                 String fecha_creacion,
                                 StatusTopico status,
                                 String autor,
                                 String curso) {

    public DatosListadoTopico(Topico topico){
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }
}
