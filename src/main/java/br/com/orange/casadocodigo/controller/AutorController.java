package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.AutorDTO;
import br.com.orange.casadocodigo.controller.form.AutorForm;
import br.com.orange.casadocodigo.entity.Autor;
import br.com.orange.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDTO> salvar(@RequestBody @Valid AutorForm form) {
        Autor autor = form.toEntity();
        this.repository.save(autor);
        return ResponseEntity.ok(new AutorDTO(autor));
    }
}
