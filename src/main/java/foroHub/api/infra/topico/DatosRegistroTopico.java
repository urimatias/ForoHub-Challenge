package foroHub.api.infra.topico;

import foroHub.api.infra.autor.DatosRegistrarAutor;
import foroHub.api.infra.curso.DatosRegistrarCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Valid
        DatosRegistrarAutor autor,
        @NotNull
        @Valid
        DatosRegistrarCurso curso) {
}
