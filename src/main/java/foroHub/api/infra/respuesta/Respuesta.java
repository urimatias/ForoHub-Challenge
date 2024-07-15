package foroHub.api.infra.respuesta;

import foroHub.api.infra.autor.Autor;
import foroHub.api.infra.topico.Topico;

import java.time.LocalDateTime;

public class Respuesta {
    private Long id;
    private String mensaje;
    private Topico topico;
    private LocalDateTime fecha;
    private Autor autor;
    private String solucion;
}
