package foroHub.api.infra.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Curso(DatosRegistrarCurso datosRegistrarCurso) {
        this.id = datosRegistrarCurso.id();
        this.nombre = datosRegistrarCurso.nombre();
        this.categoria = datosRegistrarCurso.categoria();
    }

}
