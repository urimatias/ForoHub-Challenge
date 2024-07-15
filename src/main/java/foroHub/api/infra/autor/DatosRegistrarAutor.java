package foroHub.api.infra.autor;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarAutor(
        @NotNull
        Long id,
        @NotNull
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String contraseña
) {
}
