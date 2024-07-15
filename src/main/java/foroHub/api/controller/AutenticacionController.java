package foroHub.api.controller;

import foroHub.api.infra.autor.Autor;
import foroHub.api.infra.autor.DatosAutenticacionAutor;
import foroHub.api.infra.security.DatosJWTToken;
import foroHub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarAutor(@RequestBody @Valid DatosAutenticacionAutor datosAutenticacionAutor){
        System.out.println(datosAutenticacionAutor.nombre());
        System.out.println(datosAutenticacionAutor.contraseña());
        Authentication authtoken = new UsernamePasswordAuthenticationToken(datosAutenticacionAutor.nombre(),
                datosAutenticacionAutor.contraseña());
        System.out.println(authtoken);
        authenticationManager.authenticate(authtoken);
        System.out.println(datosAutenticacionAutor.nombre());
        System.out.println(datosAutenticacionAutor.contraseña());
        var autorAutenticado = authenticationManager.authenticate(authtoken);
        var JWTtoken = tokenService.generarToken((Autor) autorAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
    }
}
