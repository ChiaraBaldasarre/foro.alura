package com.foro.alura.dto;

import com.foro.alura.topico.StatusTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// @NotNull para ENUMS (StatusTopico)
// @NotNull @Valid para objetos:
//                      autor -> Usuario (nombre, email, contraseña)
//                      curso -> (nombre -> @NotBlank, categoria -> enum/objeto @NotNull)
//                      datosRegistroUsuario(@NotBlank nombre, @NotBlank @Email email, @NotBlank contraseña)

public record DatosRegistroTopico(@NotBlank String titulo,
                                  @NotBlank String mensaje,
                                  @NotBlank @Pattern(regexp = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$") String fecha_creacion,
                                  @NotNull StatusTopico status,
                                  @NotBlank String autor,
                                  @NotBlank String curso) {


}
