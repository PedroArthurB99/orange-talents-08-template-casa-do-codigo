package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.PaisDTO;
import br.com.orange.casadocodigo.controller.form.PaisForm;
import br.com.orange.casadocodigo.entity.Pais;
import br.com.orange.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public ResponseEntity<PaisDTO> cadastrar(@RequestBody @Valid PaisForm form) {
        Pais pais = form.toEntity();
        this.repository.save(pais);
        return ResponseEntity.ok(new PaisDTO(pais));
    }
}
