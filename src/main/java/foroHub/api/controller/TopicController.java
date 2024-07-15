package foroHub.api.controller;

import foroHub.api.infra.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topico")
public class TopicController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        System.out.println(datosRegistroTopico);
        Topico topico = new Topico(datosRegistroTopico);
        System.out.println(topico.toString());

        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> topicoList(@PageableDefault(sort = "fecha", direction = Sort.Direction.ASC, size = 6) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findByEstatusTrue(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DatosListadoTopico>> topicoEspecifico(@PathVariable Long id){
        return ResponseEntity.ok(topicoRepository.findById(id).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }
}
