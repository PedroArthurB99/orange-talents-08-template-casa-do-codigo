package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.EstadoDTO;
import br.com.orange.casadocodigo.controller.form.EstadoForm;
import br.com.orange.casadocodigo.entity.Estado;
import br.com.orange.casadocodigo.repository.EstadoRepository;
import br.com.orange.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository repository;

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<EstadoDTO> cadastrar(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.toEntity(this.paisRepository);
        this.repository.save(estado);
        return ResponseEntity.ok(new EstadoDTO(estado));
    }
}
