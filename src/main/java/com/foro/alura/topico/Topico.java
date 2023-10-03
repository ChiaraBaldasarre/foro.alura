package com.foro.alura.topico;

import com.foro.alura.dto.DatosRegistroTopico;
import jakarta.persistence.*;
import lombok.*;

// Persistencia de datos con la Base de Datos

@Table(name = "topicos")
@Entity(name = "Topico")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha_creacion;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    private String autor;
    private String curso;
    private boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.fecha_creacion = datosRegistroTopico.fecha_creacion();
        this.status = datosRegistroTopico.status();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if(datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }
        if(datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }
    }

    public void desactivarTopico() {
        this.activo = false;
    }
}
