package foroHub.api.infra.topico;

import foroHub.api.infra.autor.DatosRegistrarAutor;
import foroHub.api.infra.curso.DatosRegistrarCurso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        DatosRegistrarAutor autor
        ) {
}
