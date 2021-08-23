package br.com.orange.casadocodigo.controller;

import br.com.orange.casadocodigo.controller.dto.CategoriaDTO;
import br.com.orange.casadocodigo.controller.form.CategoriaForm;
import br.com.orange.casadocodigo.entity.Categoria;
import br.com.orange.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDTO> cadastrar(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.toEntity();
        this.repository.save(categoria);
        return ResponseEntity.ok(new CategoriaDTO(categoria));
    }

}
