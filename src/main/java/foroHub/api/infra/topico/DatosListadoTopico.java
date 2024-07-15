package foroHub.api.infra.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
            Long id,
            String titulo,
            String mensaje,
            LocalDateTime fecha,
            Boolean estatus,
            String autor,
            String curso
) {

    public DatosListadoTopico (Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFecha(), topico.getEstatus(), topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
