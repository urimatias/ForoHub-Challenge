package foroHub.api.infra.respuesta;

import foroHub.api.infra.autor.Autor;
import foroHub.api.infra.topico.Topico;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        String mensaje,
        Topico topico,
        Autor autor,
        String solucion) {
}
